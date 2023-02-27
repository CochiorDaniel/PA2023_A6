public class Bonus {
    public static void main(String[] args) {
//        int cinclu = 6;
//        Bonus1(cinclu);
//        int nrNoduri = 8, kgrad = 5;
//        Bonus2(nrNoduri, kgrad);
        int nrNoduri=0, kGrad=0;
        if(args.length == 1){
            try{
                nrNoduri = Integer.parseInt(args[0]);
            }
            catch (Exception exception){
                System.out.println("Argumentul primit nu este un int!");
                System.exit( 1 );
            }
            Bonus1(nrNoduri);
        }
        if(args.length == 2){
            try{
                nrNoduri = Integer.parseInt(args[0]);
                kGrad = Integer.parseInt(args[1]);
            }
            catch(Exception exception){
                System.out.println("Cel putin unul din argumentele primite nu este un int!");
                System.exit( 1 );
            }
            Bonus2(nrNoduri,kGrad);
        }
    }

    public static void Bonus1(int ciclu) {
        if (ciclu < 3)
            System.out.println("Nu esista cicluri cu atatea noduri");
        else {

            int[][] matriceAd = new int[ciclu][ciclu];
            for (int i = 0; i < ciclu; i++)
                for (int j = 0; j < ciclu; j++)
                    if (j + 1 == i || j - 1 == i)
                        matriceAd[i][j] = 1;
                    else
                        matriceAd[i][j] = 0;
            matriceAd[0][ciclu - 1] = 1;
            matriceAd[ciclu - 1][0] = 1;


            int n = ciclu;
            while (n > 1) {
                for (int i = 0; i < ciclu; i++) {
                    int[] temp = new int[ciclu];
                    for (int k = 0; k < ciclu; k++)
                        temp[k] = matriceAd[i][k];

                    for (int j = 0; j < ciclu; j++) {
                        if (j == 0) {
                            matriceAd[i][j] = temp[j + 1] + temp[ciclu - 1];
                        } else if (j == ciclu - 1) {
                            matriceAd[i][j] = temp[j - 1] + temp[0];
                        } else {
                            matriceAd[i][j] = temp[j + 1] + temp[j - 1];
                        }
                    }
                }
                n--;
            }

            for (int i = 0; i < ciclu; i++) {
                for (int j = 0; j < ciclu; j++)
                    System.out.print(matriceAd[i][j] + " ");
                System.out.println();
            }
        }
    }

    public static void Bonus2(int nrNoduri, int kgrad) {
        if ((nrNoduri < kgrad + 1) || ((nrNoduri * kgrad) % 2 != 0))
            System.out.println("Conditiile necesare de existenta nu sunt indeplinite!");
        else {

            int[][] matrice = new int[nrNoduri][nrNoduri];
            if (kgrad == 0) {
                for (int i = 0; i < nrNoduri; i++)
                    for (int j = 0; j < nrNoduri; j++)
                        matrice[i][j] = 0;
            }
            else if (kgrad == nrNoduri - 1) {
                for (int i = 0; i < nrNoduri; i++)
                    for (int j = 0; j < nrNoduri; j++) {
                        if (i == j)
                            matrice[i][j] = 0;
                        else
                            matrice[i][j] = 1;
                    }
            }
            else{
                int fl = 0;
                if (kgrad % 2 != 0) {
                    kgrad--;
                    fl = 1;
                }

                for (int i = 0; i < nrNoduri; i++) {
                    for (int j = 0; j < nrNoduri; j++) {
                        if (i == 0) {
                            if (j != 0 && (j < kgrad / 2 + 1 || j > nrNoduri - kgrad / 2 - 1))
                                matrice[i][j] = 1;
                        } else {
                            if (j == 0)
                                matrice[i][j] = matrice[i - 1][nrNoduri - 1];
                            else
                                matrice[i][j] = matrice[i - 1][j - 1];
                        }
                    }
                }

                if(fl == 1){
                    kgrad++;
                    for(int i=0; i<nrNoduri/2; i++){
                        matrice[i][i+nrNoduri/2] = 1;
                        matrice[(i+nrNoduri/2)][i] = 1;
                    }
                }
            }


                for (int i = 0; i < nrNoduri; i++) {
                    for (int j = 0; j < nrNoduri; j++)
                        System.out.print(matrice[i][j] + " ");
                    System.out.println();
                }

            }

        }
}