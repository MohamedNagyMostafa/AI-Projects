/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routing;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author Mohamed Nagy
 */
public class Routing {

    private static State initialCity;
    private static State destinationCity;
    private static final String FAIL = "FAIL";
    private static final String SUCC = "SUCCESS";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Path path = generateMap();
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
        path.addState(Arad, Zerind);
        path.addState(Arad, Sibiu);
        path.addState(Arad, Timisoara);
        
        path.addState(Zerind, Oradea);
        path.addState(Zerind, Arad);

        path.addState(Timisoara, Arad);
        path.addState(Timisoara, Lugoj);
        
        path.addState(Oradea, Zerind);
        path.addState(Oradea, Sibiu);
        
        path.addState(Lugoj, Timisoara);
        path.addState(Lugoj, Mehnadia);
            
        path.addState(Sibiu, Oradea);
        path.addState(Sibiu, Arad);
        path.addState(Sibiu, Fagars);
        path.addState(Sibiu, Rimnicu);
        
        path.addState(Mehnadia, Lugoj);
        path.addState(Mehnadia, Drobeta);
        
        path.addState(Drobeta, Mehnadia);
        path.addState(Drobeta, Cralova);
        
        path.addState(Cralova, Rimnicu);
        path.addState(Cralova, Drobeta);
        path.addState(Cralova, Pitesti);
        
        path.addState(Rimnicu, Cralova);
        path.addState(Rimnicu, Sibiu);
        path.addState(Rimnicu, Pitesti);
        
        path.addState(Pitesti, Cralova);
        path.addState(Pitesti, Rimnicu);
        path.addState(Pitesti, Bucharest);
        
        path.addState(Fagars, Sibiu);
        path.addState(Fagars, Bucharest);
        
        path.addState(Bucharest, Pitesti);
        path.addState(Bucharest, Fagars);
        path.addState(Bucharest, Urziceni);
        path.addState(Bucharest, Glurgiu);
        
        path.addState(Urziceni, Hisova);
        path.addState(Urziceni, Bucharest);
        path.addState(Urziceni, Vaslui);
        
        path.addState(Hisova, Urziceni);
        path.addState(Hisova, Eforie);
        
        path.addState(Iasi, Vaslui);
        path.addState(Iasi, Neamt);

        path.addState(Vaslui, Urziceni);
        path.addState(Vaslui, Iasi);

        initialCity = Arad;
        destinationCity = Bucharest;
        
        return path;
    }
    
}
