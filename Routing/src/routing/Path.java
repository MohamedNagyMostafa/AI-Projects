/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import javafx.util.Pair;

/**
 *
 * @author Mohamed Nagy
 */
public class Path {
    private final LinkedList<State> mLinkedList[];
    private HashMap<String,Integer> mPathCost;
    
    public Path(int cities){
        mLinkedList = new LinkedList[cities];
        mPathCost = new HashMap<>();
        
        for(int i = 0; i < cities; i++){
            mLinkedList[i] = new LinkedList<>();
        }
    }

    public void addState(State state1, State state2, int cost){
        mLinkedList[state1.getStateId()].add(state2);
        mPathCost.put(encode(state1, state2), cost);
    }
    
    public Iterator<State> getFrontiers(State state){
        return mLinkedList[state.getStateId()].descendingIterator();
    }
    
    public LinkedList<State> getFrontiersLinkedList(State state){
        return mLinkedList[state.getStateId()];
    }
    
    public int getCost(State state1, State state2){
        return mPathCost.get(encode(state1, state2));
    }
    
    private String encode(State state1, State state2){
        return state1.getmName() + "-" + state2.getmName();
    }
}
