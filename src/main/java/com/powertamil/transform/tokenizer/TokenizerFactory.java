package com.powertamil.transform.tokenizer;

import java.io.InputStream;

public interface TokenizerFactory {

    /**
     * @param toTokenize the string to tokenize
     * @return the new tokenizer
     */
    Tokenizer createTokenizer(String toTokenize);

    /**
     * @param toTokenize
     * @return
     */
    Tokenizer createTokenizer(InputStream toTokenize);

    /**
     * TokenPreProcessor is invoked to process some raw tokens before processing.
     *
     * Sets a TokenPreProcessor for every tokenizer
     *
     * @param preProcessor the token pre processor to use
     */
    void setTokenPreProcessor(TokenPreProcess preProcessor);

    /**
     * Returns TokenPreProcessor set for this TokenizerFactory instance
     *
     * @return TokenPreProcessor instance, or null if no preprocessor was defined
     */
    TokenPreProcess getTokenPreProcessor();
}

