package Homework;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class Problem {
    private ArrayList<Location> locations;
    private ArrayList<Road> roads;
    private ArrayList<ArrayList<Location>> edges;

    public Problem(){
        locations = new ArrayList<>();
        roads = new ArrayList<>();
        edges = new ArrayList<ArrayList<Location>>();
    }

    public void addLocations(Location location){
        int fl = 0;
        for(Location loc : locations)
            if(loc.equals(location)) {
                fl = 1;
                break;
            }
        if(fl == 0) {
            locations.add(location);
            ArrayList<Location> temp = new ArrayList<>();
            temp.add(location);
            edges.add(temp);
        }
    }
    public void addRoads(Road road){
        int fl = 0;
        for(Road r : roads)
            if(r.equals(road)) {
                fl = 1;
                System.out.println(r.name +" is already added!");
                break;
            }
        if(fl == 0) {
            roads.add(road);
            addLocations(road.getLocation1());
            addLocations(road.getLocation2());
            addEdges(road);
        }
    }

    private void addEdges(Road road){
        /**
         * Aceasta metoda adauga in ArrayList-ul de ArrayList-uri, edges, Locatii pentru fiecare drum adaugat.
         * Daca drumurile se gasesc deja in edges se adauga noua locatie in liista de adiacenta a locatiei deja
         * prezente in edges, iar daca nu, se creeaza doua ArrayList-uri cu locartiile l1-l2, respectiv
         * l2-l1 si se adauga la edges.
         */
        int fl1=0, fl2=0;
        ArrayList<Location> temp = new ArrayList<>();
        temp.add(road.getLocation1());
        temp.add(road.getLocation2());
        ArrayList<Location> temp2 = new ArrayList<>();
        temp2.add(road.getLocation2());
        temp2.add(road.getLocation1());
        for (ArrayList<Location> l: edges){
            if(l.get(0).equals(road.getLocation1())){
                l.add(road.getLocation2());
                fl1 = 1;
            }
            if(l.get(0).equals(road.getLocation2())){
                l.add(road.getLocation1());
                fl2 = 1;
            }
        }
        if(fl1 == 0)
            edges.add(temp);
        if (fl2 == 0)
            edges.add(temp2);
    }

    public boolean verifyInstance(){
        /**
         * Aceasta metoda verifica daca instanta problemei este valida. Pentru fiecare drum din instanta
         * problemei, se apeleaza metoda verifyLength(), care verifica pentru fiecare drum daca lungimea
         * drumului este mai mare sau egala decat distanta dintre cele loua locatii pe care le uneste drumul.
         * In cazul in care aceasta conditie nu este respectata, metoda returneaza false.
         */
        for(Road r : roads)
            if(r.verifyLength() == false)
                return false;
        return true;
    }

    public void printLocations(){
        for(Location loc : locations)
            System.out.println(loc);
    }
    public void printRoads(){
        for(Road r : roads)
            System.out.println(r);
    }

    public void printEdges() {
        for (ArrayList<Location> l : edges) {
            System.out.print("Locatia " + l.get(0).getName() + " are drum direct catre: ");
            for (int i = 1; i < l.size(); i++)
                System.out.print(l.get(i).getName() + " ");
            System.out.println();
        }
    }

    public boolean isRoad(Location l1, Location l2){
        /**
         *  Aceasta metoda verifica printr-o intr-o maniera BFS daca se poate ajunge de la locatia l1
         *  la locatia l2, folosind drumurile disponibile din instanta curenta a problemei.
         *  Cautarea BFS se face cu ajutorul unei cozi si a vectorului visited care memoreaza
         *  indexul locatiilor vizitate. Cautarea se opreste in cazul in care se gaseste un drum
         *  de la l1 la l2 si metoda returneaza true, iar in cazul in care nu se gaseste,
         *  metoda returneaza fals.
         */

        boolean [] visited = new boolean[locations.size()];
        LinkedBlockingQueue<Location> queue = new LinkedBlockingQueue<Location>();

        visited [getIndex(l1)] = true;
        queue.add(l1);
        while (!queue.isEmpty()){
            if(queue.peek().equals(l2))
                return true;
            Location temp =  queue.remove();
            for(ArrayList<Location> loc : edges)
                if(loc.get(0).equals(temp)) {
                    for (int i = 1; i < loc.size(); i++) {
                        if (!visited[getIndex(loc.get(i))]) {
                            queue.add(loc.get(i));
                            visited[getIndex(loc.get(i))] = true;
                        }
                    }
                    break;
                }

        }
        return false;
    }


    private int getIndex(Location loc){
        /**
         *  Aceasta metoda returneaza indexul locatiei loc din ArrayList-ul locations.
         */
        int i;
        for(i = 0; i<locations.size(); i++){
            if(locations.get(i).equals(loc))
                break;
        }
        return i;
    }




}
