package com.powertamil.transform.tokenizer;

/**
 *  A token is the basic lexical unit of the language.
 *  A Tokenizer creates such tokens from input String/Stream
 */

import java.util.List;

public interface Tokenizer {

    /**
     * An iterator for tracking whether
     * more tokens are left in the iterator not
     * @return whether there is anymore tokens
     * to iterate over
     */
    boolean hasMoreTokens();

    /**
     * The number of tokens in the tokenizer
     * @return the number of tokens
     */
    int countTokens();

    /**
     * The next token (word usually) in the string
     * @return the next token in the string if any
     */
    String nextToken();

    /**
     * Returns a list of all the tokens
     * @return a list of all the tokens
     */
    List<String> getTokens();

    /**
     * Set the token pre process
     * @param preProcessor the token pre processor to set
     */
    void setTokenPreProcessor(TokenPreProcess preProcessor);

}