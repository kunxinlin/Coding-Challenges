package dataStructures;

import java.util.ArrayList;
import java.util.Scanner;

public class JavaArraylist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<ArrayList<Integer>> lines = new ArrayList<>();
        for(int i = 0; i < n; i++){
            ArrayList<Integer> list = new ArrayList<>();
            int numOfInts = scanner.nextInt();
            for(int j = 0; j < numOfInts; j++){
                list.add(scanner.nextInt());
            }
            lines.add(list);
        }

        n = scanner.nextInt();
        for(int i = 0; i< n; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            try{
                int res = lines.get(x-1).get(y-1);
                System.out.println(res);
            }catch(IndexOutOfBoundsException e){
                System.out.println("ERROR!");
            }
        }
    }
}
