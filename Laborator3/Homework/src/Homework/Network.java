package Homework;

import java.util.ArrayList;
import java.util.List;
public class Network {
    private List<Node> nodes;
    public Network(){
        nodes = new ArrayList<>();
    }

    public Network(List<Node> nodes){ this.nodes = nodes; }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public int nodeImportance(Node node){
        // metoda care calculeaza gradul unui nod in functie de tipul acestuia
        // daca nodul este de tip person, ma uit cate conexiuni are persoana respectiva
        // daca nodul este o companie, numar toate persoanele care au conexiune cu acea companie
        if( !nodes.contains(node))
            return 0;
        int count = 0;
        if( node instanceof Person)
            count = ((Person) node).getRelationships().size();
        else if( node instanceof Company){
            for (Node n : nodes){
                if( n instanceof Person)
                    if( ((Person) n).getRelationships().containsKey(node) )
                        count++;
            }
        }
        return count;
    }
    public void printNetwork(){
        for (Node n : nodes) {
            System.out.print(n);
            System.out.println(" are " + nodeImportance(n) + " relatii");
        }
    }

    public void printSorted(){
        // sortare cu lambda expresie
        // daca grad(nodul2) - grad(nodul1) > 0 => nodul 2 are mai multe conexiuni decat nodul 1,
        // iar sortarea se face pe baza acestui criteriu
        nodes.sort( (node1, node2) -> nodeImportance(node2) - nodeImportance(node1) );
        printNetwork();
    }

}