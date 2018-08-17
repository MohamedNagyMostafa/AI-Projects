/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail.filter.spams;

import mail.filter.spams.controller.Controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Mohamed Nagy
 */
public class Ham extends Controller implements Controller.Callbacks{
    
    private int mTotalWords = 0;
    private List<String> mHams;
    private HashMap<String, Integer> mHamWords;
    
    public Ham(List<String> spams){
        mHams = spams;
        init();
    }
    
    public Ham(){
        mHams = new ArrayList<>();
        init();
    }
    
    private void init(){
        mHamWords = new HashMap<>();
        
        if(mHams != null){
            mHams.forEach((sentence) -> {
                mTotalWords += splitingToWords(sentence, mHamWords);
            });
        }
    }
    
    public void addSentence(String sentence){
        mTotalWords += super.addSentence(sentence, mHams, mHamWords);
    }
    
    public int getSentencesCount(){
        return super.getSentencesCount(mHams);
    }
    
    public int getWordsCount(){
        return super.getWordsCount(mHamWords);
    }
    
    public int getWordCount(String word){
        return super.getWordCount(word, mHamWords);
    }
    
    public float getWordMultiplier(String feature){
        return super.getWordMultiplier(feature, mHamWords, mTotalWords);
    }
    
    public float getWordMultiplierLaplace(String feature, int k, int x_abs){
        return super.getWordMultiplierLaplacian(feature, mHamWords, mTotalWords, k, x_abs);
    }

    @Override
    public HashMap<String, Integer> getDictionary() {
        return mHamWords;
    }
}
