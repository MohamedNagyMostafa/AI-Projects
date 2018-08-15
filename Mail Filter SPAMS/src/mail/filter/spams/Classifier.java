/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail.filter.spams;

import mail.filter.spams.controller.Controller;
import java.util.function.Function;
import javafx.util.Pair;

/**
 *
 * @author Mohamed Nagy
 */
public class Classifier implements Function<String, float[]>{
    public static final int SPAM = 0;
    public static final int HAM = 1;
    private Controller[] mController;
    
    public Classifier(Controller[] controller){
        mController = controller;
    }
    
    @Override
    public float[] apply(String features) {
        assert features != null;
        float[] probability = new float[mController.length];
        
        probability = bayesNetwork(probability, features);
        return probability;
    }
    
    private float[] bayesNetwork(float [] probability, String features){
        probability[SPAM] = bayesNetworkSpam(features);
        probability[HAM] = 1 - probability[SPAM];
        
        return probability;
    }
    
    private float bayesNetworkSpam(String features){
        Spam spam = ((Spam) mController[SPAM]);
        Ham ham = ((Ham) mController[HAM]);
        
        float p_spam = spam.getSentencesCount()/(float)(spam.getSentencesCount()+ ham.getSentencesCount());
        float p_ham = 1 - p_spam;
        float p_jointSpamAndMessage = p_spam * spam.getWordMultiplier(features);
        float p_jointHamAndMessage  = p_ham * ham.getWordMultiplier(features);
        
        return p_jointSpamAndMessage/(p_jointSpamAndMessage + p_jointHamAndMessage);
    }
    
}
