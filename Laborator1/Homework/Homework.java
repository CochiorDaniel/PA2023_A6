import javax.print.DocFlavor;
import java.util.Scanner;
import java.util.Set;

public class Homework {
    public static long time = System.nanoTime();
    public static void main(String[] args) {
        int n = 0;
        if(args.length == 1){
            try{
                n = Integer.parseInt(args[0]);
            }
            catch (Exception exception){
                System.out.println("Argumentul primit nu este un int!");
                System.exit( 1 );
            }
            if( n < 1){
                System.out.println("Numarul trebuie sa fie pozitiv si mai mare egal decat 1!");
            }
            else{
                matriceLatina(n);
            }
        }
        else {
            System.out.println("Numarul argumentelor nu se potriveste cu cel al functiei!");
        }

    }
    public static void matriceLatina(int n) {
        int[][] latin = new int[n][n];
        String[] rand = new String[n];
        StringBuilder construieste = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    latin[i][j] = j + 1;
                } else {
                    int temp = latin[i - 1][n - 1];
                    for (int l = 0; l < n - 1; l++) {
                        latin[i][l + 1] = latin[i - 1][l];
                    }
                    latin[i][0] = temp;
                }
            }
            for (int k = 0; k<n; k++){
                construieste.append(latin[i][k]);
                construieste.append(' ');
            }
            rand[i]=construieste.toString();
            //System.out.println(rand[i]);
            construieste = new StringBuilder();
        }

        if(n > 30000){
            System.out.println(System.nanoTime() - time);
        }
        else{
            for(int i=0; i<n; i++)
                System.out.println(rand[i]);
        }

    }


}

