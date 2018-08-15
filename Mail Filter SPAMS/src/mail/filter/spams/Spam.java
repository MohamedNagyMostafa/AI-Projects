/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail.filter.spams;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Mohamed Nagy
 */
public class Spam {
    private static final String SEPARATOR = " ";
    private static final int DEFAULT = 0;
    private List<String> mSpams;
    private HashMap<String, Integer> mSpamWords;
    
    public Spam(List<String> spams){
        mSpams = spams;
        init();
    }
    
    public Spam(){
        mSpams = new ArrayList<>();
        init();
    }
    
    private void init(){
        mSpamWords = new HashMap<>();
        
        if(mSpams != null){
            mSpams.forEach((sentence) -> {
                splitingToWords(sentence);
            });
        }
    }
    
    private void splitingToWords(String sentence){
        String[] words = sentence.split(SEPARATOR);
        
        for(String word: words){
            if(mSpamWords.containsKey(word))
                mSpamWords.put(word, mSpamWords.get(word) + 1);
            else
                mSpamWords.put(word, DEFAULT + 1);
        }
    }
    
    public void addSentence(String sentence){
        mSpams.add(sentence);
        splitingToWords(sentence);
    }
    
    public int getSentencesCount(){
        return mSpams.size();
    }
    
    public int getWordsCount(){
        return mSpamWords.size();
    }
    
    public int getWordCount(String word){
        return mSpamWords.containsKey(word)?mSpamWords.get(word):DEFAULT;
    }
}
