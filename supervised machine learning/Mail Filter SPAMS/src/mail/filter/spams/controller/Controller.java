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
    
    protected float getWordMultiplierLaplacian(String feature, HashMap<String, Integer> dictionary, int totalWords, int k, int x_abs){
        String[] words = feature.split(SEPARATOR);
        float multiplier = 1;
        
        for(String word: words)
            multiplier *= dictionary.containsKey(word.toLowerCase())? (dictionary.get(word.toLowerCase())+k)/(double)(totalWords+k* x_abs):
                    k/(double)(totalWords+k* x_abs);
        
        return multiplier;
    }
    
    public static int getUniqueWordsCount(HashMap<String, Integer> dictionary1, HashMap<String, Integer> dictionary2){
        int uniqueCount = 0;
        
        if(dictionary1.size() < dictionary2.size())
            uniqueCount = compaining(dictionary1, dictionary2);
        else
            uniqueCount = compaining(dictionary2, dictionary1);

        return uniqueCount;
    }
    
   private static int compaining(HashMap<String, Integer> dictionary1, HashMap<String, Integer> dictionary2){
       int elements = 0;
       
       for(String word: dictionary1.keySet())
           if(!dictionary2.containsKey(word)) elements++; 
       
        return dictionary2.size() + elements;
   }
   
   public interface Callbacks{
       HashMap<String, Integer> getDictionary();
   }
}
