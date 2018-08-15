/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail.filter.spams;

import mail.filter.spams.controller.Controller;

/**
 *
 * @author Mohamed Nagy
 */
public class MailFilterSPAMS {

    
    public static void main(String[] args) {
        Spam spam = new Spam();
        spam.addSentence("Offer is secret");
        spam.addSentence("Click secret link");
        spam.addSentence("Secret sports link");
        
        Ham ham = new Ham();
        ham.addSentence("Play sports today");
        ham.addSentence("Went play sports");
        ham.addSentence("Secret sports event");
        ham.addSentence("Sports is today");
        ham.addSentence("Sports costs money");
        
        Controller[] controller = new Controller[2];
        
        controller[Classifier.SPAM] = spam;
        controller[Classifier.HAM] = ham;
        
        Classifier classifier = new Classifier(controller);
        
        float[] pro = classifier.apply("secret is secret");
        
        System.out.println("Spam: " + pro[Classifier.SPAM]* 100 +"%" + " Ham: " + pro[Classifier.HAM]* 100 +"%");
    }
    
}
