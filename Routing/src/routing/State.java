/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routing;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Mohamed Nagy
 */
public class State {
    private String mName;
    private int mStateId;
    private boolean mIsExplored;
    
    public State(String name){
        mName = name;
        mIsExplored = false;
        mStateId = StateIdCreator.generateId();
    }

    public String getmName() {
        return mName;
    }
    
    public void explored(){
        mIsExplored = true;
    }
    
    public boolean isExplored(){
        return mIsExplored;
    }

    public int getStateId() {
        return mStateId;
    }
    
}
