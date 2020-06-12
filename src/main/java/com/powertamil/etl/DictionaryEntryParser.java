package com.powertamil.etl;

import com.powertamil.dictionary.WordMeaning;

import java.io.IOException;
import java.io.InputStream;

import java.util.Map;
import java.util.TreeMap;

//Dictionary Entry Parser (DEP)
public interface DictionaryEntryParser {

    public TreeMap<String, WordMeaning> parseAllAgaraMuthaliFiles(String workingdir);

}
