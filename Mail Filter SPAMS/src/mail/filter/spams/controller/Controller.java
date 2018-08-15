/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail.filter.spams.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Mohamed Nagy
 */
public class Controller {
    private static final String SEPARATOR = " ";
    private static final int DEFAULT = 0;
    
    protected int splitingToWords(String sentence, HashMap<String, Integer> dictionary){
        String[] words = sentence.split(SEPARATOR);
        int total = words.length;
        
        for(String word: words){
            if(dictionary.containsKey(word.toLowerCase()))
                dictionary.put(word.toLowerCase(), dictionary.get(word.toLowerCase()) + 1);
            else
                dictionary.put(word.toLowerCase(), DEFAULT + 1);
        }
        
        return total;
    }
    
    protected int addSentence(String sentence, List<String> sentenceStore, HashMap<String, Integer> dictionary){
        sentenceStore.add(sentence);
        return splitingToWords(sentence, dictionary);
    }
    
    protected int getSentencesCount(List<String> sentenceStore){
        return sentenceStore.size();
    }
    
    protected int getWordsCount(HashMap<String, Integer> dictionary){
        return dictionary.size();
    }
    
    protected int getWordCount(String word, HashMap<String, Integer> dictionary){
        return dictionary.containsKey(word.toLowerCase())?dictionary.get(word):DEFAULT;
    }
    
    protected float getWordMultiplier(String feature, HashMap<String, Integer> dictionary, int totalWords){
        String[] words = feature.split(SEPARATOR);
        float multiplier = 1;
        
        for(String word: words)
            multiplier *= dictionary.containsKey(word.toLowerCase())? dictionary.get(word.toLowerCase())/(double)totalWords:0;
        

        return multiplier;
    }
}
