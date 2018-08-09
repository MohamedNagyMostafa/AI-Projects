/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routing;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author Mohamed Nagy
 */
public class Routing {

    private static State initialCity;
    private static State destinationCity;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Path path = generateMap();
        //breadthFirstSearch(path);
        uniformCostSearch(path);
        
    }
    private static void uniformCostSearch(Path path){
        
        System.out.println("\n Uniform Search Cose \n");
        UniformCostSearch uniformCostSearch = new UniformCostSearch(path);
        
        List<UniformCostSearch.PathCost> pathCosts = uniformCostSearch.apply(initialCity, destinationCity);
        
        printRoute(pathCosts);
    }
    
    private static void breadthFirstSearch(Path path){
        
        List<State> frontiers = new ArrayList<>();
        
        frontiers.add(initialCity);
        initialCity.isExplored();
        if(!initialCity.equals(destinationCity))
            printState(initialCity);
           
        Iterator<State> frontiersIterator = frontiers.listIterator();

        ex: while(frontiersIterator.hasNext()){
            State state = frontiersIterator.next();
            state.explored();
            frontiersIterator.remove();
            Iterator<State> stateFrontiers = path.getFrontiers(state);

            while(stateFrontiers.hasNext()){
                State fState = stateFrontiers.next();

                if(!fState.isExplored()){
                    frontiers.add(fState);
                    fState.explored();
                    printState(fState);

                    if(destinationCity.equals(fState)){
                        break ex;
                    }
                }

            }
            frontiersIterator = frontiers.iterator();
            

        }
    }

  
    private static void printState(State intiState){
        System.out.println(intiState.getmName());
    }
    
    private static void printRoute(List<UniformCostSearch.PathCost> pathCosts){
        UniformCostSearch.PathCost bestPath = pathCosts.get(0);
        int cost = pathCosts.get(0).cost;
        
        for(UniformCostSearch.PathCost pathCost: pathCosts){
            if(cost > pathCost.cost){
                cost = pathCost.cost;
                bestPath = pathCost;
            }
            System.out.println("\n============================\n");
            System.out.println("Cost: " + pathCost.cost + "\n");
            System.out.println("path route: ");
            for(State state: pathCost.mStates){
                System.out.println(state.getmName());
            }
        }
        
        System.out.println("\n==========BEST PATH==========\n");
            System.out.println("Cost: " + bestPath.cost + "\n");
            System.out.println("path route: ");
            for(State state: bestPath.mStates){
                System.out.println(state.getmName());
            }
    }
    
  
    public static Path generateMap(){
        State Arad = new State("Arad");
        State Zerind = new State("Zerind");
        State Oradea = new State("Oradea");
        State Sibiu = new State("Sibiu");
        State Fagars = new State("Fagars");
        State Bucharest = new State("Bucharest");
        State Urziceni = new State("Urziceni");
        State Vaslui = new State("Vaslui");
        State Iasi = new State("Iasi");
        State Neamt = new State("Neamt");
        State Hisova = new State("Hisova");
        State Eforie = new State("Eforie");
        State Glurgiu = new State("Glurgiu");
        State Pitesti = new State("Pitesti");
        State Rimnicu = new State("Rimnicu Vilcea");
        State Cralova = new State("Cralova");
        State Drobeta = new State("Drobeta");
        State Mehnadia = new State("Mehnadia");
        State Lugoj = new State("Lugoj");
        State Timisoara = new State("Timisoara");
        
        Path path = new Path(20);
        path.addState(Arad, Zerind, 75);
        path.addState(Arad, Sibiu, 140);
        path.addState(Arad, Timisoara, 118);
        
        path.addState(Zerind, Oradea, 71);
        path.addState(Zerind, Arad, 75);

        path.addState(Timisoara, Arad, 118);
        path.addState(Timisoara, Lugoj, 111);
        
        path.addState(Oradea, Zerind, 71);
        path.addState(Oradea, Sibiu, 151);
        
        path.addState(Lugoj, Timisoara, 111);
        path.addState(Lugoj, Mehnadia, 70);
            
        path.addState(Sibiu, Oradea, 140);
        path.addState(Sibiu, Arad, 151);
        path.addState(Sibiu, Fagars, 99);
        path.addState(Sibiu, Rimnicu, 80);
        
        path.addState(Mehnadia, Lugoj, 70);
        path.addState(Mehnadia, Drobeta, 75);
        
        path.addState(Drobeta, Mehnadia, 75);
        path.addState(Drobeta, Cralova, 120);
        
        path.addState(Cralova, Rimnicu, 146);
        path.addState(Cralova, Drobeta, 120);
        path.addState(Cralova, Pitesti, 138);
        
        path.addState(Rimnicu, Cralova, 146);
        path.addState(Rimnicu, Sibiu, 80);
        path.addState(Rimnicu, Pitesti, 97);
        
        path.addState(Pitesti, Cralova, 138);
        path.addState(Pitesti, Rimnicu, 97);
        path.addState(Pitesti, Bucharest, 101);
        
        path.addState(Fagars, Sibiu, 99);
        path.addState(Fagars, Bucharest, 211);
        
        path.addState(Bucharest, Pitesti, 101);
        path.addState(Bucharest, Fagars, 211);
        path.addState(Bucharest, Urziceni, 85);
        path.addState(Bucharest, Glurgiu, 90);
        
        path.addState(Urziceni, Hisova, 98);
        path.addState(Urziceni, Bucharest, 85);
        path.addState(Urziceni, Vaslui, 142);
        
        path.addState(Hisova, Urziceni, 98);
        path.addState(Hisova, Eforie, 86);
        
        path.addState(Iasi, Vaslui, 92);
        path.addState(Iasi, Neamt, 87);

        path.addState(Vaslui, Urziceni, 142);
        path.addState(Vaslui, Iasi, 92);

        initialCity = Arad;
        destinationCity = Bucharest;
        
        return path;
    }
    
}
