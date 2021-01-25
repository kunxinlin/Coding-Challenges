package string;

import java.util.Scanner;
import java.util.regex.Pattern;

public class JavaRegex {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            //System.out.println(IP.matches(new MyRegex().pattern));
        }
    }
}

class MyRegex{
    String zero255 = "([0-9]|[0-9][0-9]|[0-1][0-9][0-9]|2[0-4][0-9]|25[0-5])";
    String pattern = zero255 + "." + zero255 + "." +zero255 + "." +zero255;
}
