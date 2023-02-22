public class Compulsory {
    public static void main(String []args) {
        System.out.println("Hello, World!");
        String [] languages  =  {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n = n*3;
        int de = Integer.parseInt("10101",2); 
        n = n+de;
        int he = Integer.parseInt("FF",16);
        n = n+he;
        n = n*6;
        int result = 0;
        //System.out.println(n);

        do{
            if(result>=10){
                n = result;
                result = 0;
            }
            while(n > 0){
                result = result + n%10;
                n = n/10;
            }
        }while(result>=10);

        //System.out.println(result);
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }
   
}




