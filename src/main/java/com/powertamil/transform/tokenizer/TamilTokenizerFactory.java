package com.powertamil.transform.tokenizer;

import java.io.InputStream;

public class TamilTokenizerFactory implements TokenizerFactory {

    private TokenPreProcess tokenPreProcess = new PunctuationPreProcessor();

    @Override
    public Tokenizer createTokenizer(String toTokenize) {
        TamilTokenizer t = new TamilTokenizer(toTokenize);
        t.setTokenPreProcessor(tokenPreProcess);
        return t;
    }

    @Override
    public Tokenizer createTokenizer(InputStream toTokenize) {
        Tokenizer t = new TamilStreamTokenizer(toTokenize);
        t.setTokenPreProcessor(tokenPreProcess);
        return t;
    }

    @Override
    public void setTokenPreProcessor(TokenPreProcess preProcessor) {

        this.tokenPreProcess = preProcessor;
    }

    /**
     * Returns TokenPreProcessor set for this TokenizerFactory instance
     * @return TokenPreProcessor instance, or null if no preprocessor was defined
     */
    @Override
    public TokenPreProcess getTokenPreProcessor() {

        return tokenPreProcess;
    }

}
