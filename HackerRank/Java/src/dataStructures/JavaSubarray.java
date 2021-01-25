package dataStructures;

import java.util.Scanner;

public class JavaSubarray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] theArray = new int[n];
        for(int i = 0; i < n; i++){
            theArray[i] = scanner.nextInt();
        }

        int negativeCount = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                sum += theArray[j];
                if(sum < 0){
                    negativeCount++;
                }
            }
            sum = 0;
        }

        System.out.println(negativeCount);
    }
}
