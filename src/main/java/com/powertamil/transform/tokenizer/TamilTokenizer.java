package com.powertamil.transform.tokenizer;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Tamil tokenizer
 */
public class TamilTokenizer implements Tokenizer {

    private StringTokenizer tokenizer;
    private TokenPreProcess tokenPreProcess;

    private List<String> tokens;
    private int index;

    public TamilTokenizer(String toTokenize) {
        tokenizer = new StringTokenizer(toTokenize);
        this.tokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            String nextToken = tokenizer.nextToken();
            this.tokens.add(nextToken);
        }

        System.out.println(this.tokens);
    }

    @Override
    public boolean hasMoreTokens() {
        return index < tokens.size();
    }

    @Override
    public int countTokens() {
        return tokens.size();
    }

    @Override
    public String nextToken() {
        String base = tokens.get(index);
        String cleaned = null;
        if (tokenPreProcess != null)
            base = tokenPreProcess.preProcess(base);
        index++;
        //System.out.println("cleaned is:: " + base);
        //System.out.println("index is:: " + index);
        return base;
    }


    @Override
    public List<String> getTokens() {
        List<String> tokens = new ArrayList<>();
        while (hasMoreTokens()) {
            tokens.add(nextToken());
        }
        return tokens;
    }

    @Override
    public void setTokenPreProcessor(TokenPreProcess tokenPreProcessor) {
        this.tokenPreProcess = tokenPreProcessor;

    }


}