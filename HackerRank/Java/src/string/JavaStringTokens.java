package string;

import java.util.Scanner;

public class JavaStringTokens {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.

        s = s.trim();

        if (s.length()==0 || s.length() > 400000){
            System.out.println(0);
        }else{
            String[] tokens = s.split("[ !,?.\\_'@]+");
            System.out.println(tokens.length);
            for(String t: tokens){
                System.out.println(t);
            }
        }
        scan.close();
    }
}
