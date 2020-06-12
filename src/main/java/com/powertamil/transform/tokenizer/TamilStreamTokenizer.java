package com.powertamil.transform.tokenizer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Tokenizer based on the {@link java.io.StreamTokenizer}
 *
 */
public class TamilStreamTokenizer implements Tokenizer {

    private StreamTokenizer streamTokenizer;
    private TokenPreProcess tokenPreProcess;
    private List<String> tokens = new ArrayList<>();
    private AtomicInteger position = new AtomicInteger(0);

    //protected static final Logger log = LoggerFactory.getLogger(TamilStreamTokenizer.class);

    public TamilStreamTokenizer(InputStream is) {
        Reader r = new BufferedReader(new InputStreamReader(is));
        streamTokenizer = new StreamTokenizer(r);

    }

    /**
     * Checks, if underlying stream has any tokens left
     *
     * @return
     */
    private boolean streamHasMoreTokens() {
        if (streamTokenizer.ttype != StreamTokenizer.TT_EOF) {
            try {
                streamTokenizer.nextToken();
            } catch (IOException e1) {
                throw new RuntimeException(e1);
            }
        }
        return streamTokenizer.ttype != StreamTokenizer.TT_EOF && streamTokenizer.ttype != -1;
    }

    /**
     * Checks, if any prebuffered tokens left, otherswise checks underlying stream
     * @return
     */
    @Override
    public boolean hasMoreTokens() {
        //log.info("Tokens size: [" + tokens.size() + "], position: [" + position.get() + "]");
        if (!tokens.isEmpty())
            return position.get() < tokens.size();
        else
            return streamHasMoreTokens();
    }

    /**
     * Returns number of tokens
     * PLEASE NOTE: this method effectively preloads all tokens. So use it with caution, since on large streams it will consume big amount of memory
     *
     * @return
     */
    @Override
    public int countTokens() {
        return getTokens().size();
    }


    /**
     * This method returns next token from prebuffered list of tokens or underlying InputStream
     *
     * @return next token as String
     */
    @Override
    public String nextToken() {
        if (!tokens.isEmpty() && position.get() < tokens.size())
            return tokens.get(position.getAndIncrement());
        return nextTokenFromStream();
    }

    /**
     * This method returns next token from underlying InputStream
     *
     * @return
     */
    private String nextTokenFromStream() {
        StringBuilder sb = new StringBuilder();


        if (streamTokenizer.ttype == StreamTokenizer.TT_WORD) {
            sb.append(streamTokenizer.sval);
        } else if (streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
            sb.append(streamTokenizer.nval);
        } else if (streamTokenizer.ttype == StreamTokenizer.TT_EOL) {
            try {
                while (streamTokenizer.ttype == StreamTokenizer.TT_EOL)
                    streamTokenizer.nextToken();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (streamHasMoreTokens())
            return nextTokenFromStream();


        String ret = sb.toString();

        if (tokenPreProcess != null)
            ret = tokenPreProcess.preProcess(ret);
        return ret;

    }

    /**
     * Returns all tokens as list of Strings
     *
     * @return List of tokens
     */
    @Override
    public List<String> getTokens() {
        //List<String> tokens = new ArrayList<>();
        if (!tokens.isEmpty())
            return tokens;

        //log.info("Starting prebuffering...");
        while (streamHasMoreTokens()) {
            tokens.add(nextTokenFromStream());
        }
        //log.info("Tokens prefetch finished. Tokens size: [" + tokens.size() + "]");
        return tokens;
    }

    @Override
    public void setTokenPreProcessor(TokenPreProcess tokenPreProcessor) {
        this.tokenPreProcess = tokenPreProcessor;
    }

}