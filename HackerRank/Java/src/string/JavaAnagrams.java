package string;

import java.util.Scanner;

public class JavaAnagrams {

    static boolean isAnagram(String a, String b){
        java.util.HashMap<Character, Integer> map = new java.util.HashMap<>();

        if(a.length() != b.length()) return false;
        a = a.toLowerCase();
        b = b.toLowerCase();

        for(int i =0; i<a.length(); i++){
            char c = a.charAt(i);
            if(map.containsKey(c)){
                map.replace(c, map.get(c)+1);
            }
            else{
                map.put(c, 1);
            }
        }


        for(int i =0; i<b.length(); i++){
            char c = b.charAt(i);
            if(!map.containsKey(c)){
                return false;
            }
            map.replace(c, map.get(c)-1);

            if(map.get(c) < 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );

    }
}
