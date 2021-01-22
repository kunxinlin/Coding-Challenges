package introduction;

import java.util.Scanner;

public class JavaLoops1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        for(int i = 1; i<=10; i++ ){
            System.out.printf("%d x %d = %d%n", N, i, N*i);
            //System.out.print(N + " x " + i + " = " + N*i + "\n");
        }


        scan.close();
    }
}
