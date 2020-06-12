package com.powertamil.transform.tokenizer;

public interface TokenPreProcess {

    /**
     * Pre process a token
     * @param token the token to pre process
     * @return the preprocessed token
     */
    String preProcess(String token);


}