/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routing;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Mohamed Nagy
 */
public class UniformCostSearch {
    
    private Path mPath;
    
    public UniformCostSearch(Path path){
        mPath = path;
    }
    
    public PathCost apply(State initialState, State destination){
       
        List<PathCost> frontiers = new ArrayList<>();
        frontiers.add(new PathCost(initialState, 0));
        
        
        if(destination.equals(initialState))
            return frontiers.get(0);
        
        PathCost pathCost;

        do{
            pathCost = addStateFrontiers(frontiers, destination);    
            
        }while (pathCost == null && !frontiers.isEmpty());
        
        return pathCost;
    }
    
    private PathCost addStateFrontiers(List<PathCost> frontiers, State destination){
        PathCost minPath = frontiers.get(0);
        int minCost = minPath.cost;
        
        for(PathCost pathCost: frontiers){
            if(pathCost.mStates.getLast().equals(destination))
                return pathCost;
            
            if(minCost > pathCost.cost){
                minCost = pathCost.cost;
                minPath = pathCost;
            }
        }
        
        expandPath(minPath, frontiers);
        
        return null;
    }
    
    private void expandPath(PathCost pathCost, List<PathCost> frontiers){
        frontiers.remove(pathCost);
        
        pathCost.mStates.getLast().explored();
        LinkedList<State> iterator = mPath.getFrontiersLinkedList(pathCost.mStates.getLast());
        addNewFrontiers(iterator, frontiers, pathCost);
        
    }
    
    private void addNewFrontiers(LinkedList<State> linkedList, List<PathCost> frontiers, PathCost pathCost){
        
        for(State state: linkedList){
            LinkedList<State> newStates = new LinkedList<>();
            
            for(State lastState: pathCost.mStates)
                newStates.add(lastState);
                
            newStates.add(state);
            
            int newCost = pathCost.cost + mPath.getCost(pathCost.mStates.getLast(), state);
            
            frontiers.add(new PathCost(newStates,newCost));
            
        }   

    }
    
    public static class PathCost{
        public LinkedList<State> mStates;
        public int cost;
        
        public PathCost(State state, int cost){
            mStates = new LinkedList<>();
            mStates.add(state);
            this.cost = cost;
        }
        
        public PathCost(LinkedList<State> linkedList, int cost){
            mStates = linkedList;
            this.cost = cost;
        }
    }
     
}
