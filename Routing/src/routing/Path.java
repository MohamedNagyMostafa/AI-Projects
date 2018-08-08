/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routing;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Mohamed Nagy
 */
public class Path {
    private final LinkedList<State> mLinkedList[];
    
    public Path(int cities){
        mLinkedList = new LinkedList[cities];
        for(int i = 0; i < cities; i++){
            mLinkedList[i] = new LinkedList<State>();
        }
    }

    public void addState(State state1, State state2){
        mLinkedList[state1.getStateId()].add(state2);
    }
    
    public Iterator<State> getFrontiers(State state){
        return mLinkedList[state.getStateId()].descendingIterator();
    }
}
