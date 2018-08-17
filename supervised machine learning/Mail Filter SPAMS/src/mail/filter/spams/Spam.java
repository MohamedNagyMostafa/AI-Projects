/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail.filter.spams;

import mail.filter.spams.controller.Controller;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Mohamed Nagy
 */
public class Spam extends Controller implements Controller.Callbacks{
    
    private int mTotalWords = 0;
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
                mTotalWords += splitingToWords(sentence, mSpamWords);
            });
        }
    }
    
    public void addSentence(String sentence){
        mTotalWords += super.addSentence(sentence, mSpams, mSpamWords);
    }
    
    public int getSentencesCount(){
        return super.getSentencesCount(mSpams);
    }
    
    public int getWordsCount(){
        return super.getWordsCount(mSpamWords);
    }
    
    public int getWordCount(String word){
        return super.getWordCount(word, mSpamWords);
    }
    
    public float getWordMultiplier(String feature){
        return super.getWordMultiplier(feature, mSpamWords, mTotalWords);
    }
    
    public float getWordMultiplierLaplace(String feature, int k, int x_abs){
        return super.getWordMultiplierLaplacian(feature, mSpamWords, mTotalWords, k, x_abs);
    }

    @Override
    public HashMap<String, Integer> getDictionary() {
        return mSpamWords;
    }
}
