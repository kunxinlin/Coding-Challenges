package CrackingTheCodingInterview.StringsArraysQuestions;

public class p9_StringRotation {
    public static void main(String[] args) {
        System.out.println(isRotation("erbottlewat", "waterbottle"));
        System.out.println(isRotation("apple", "leapp"));
        System.out.println(isRotation("apple", "pineapple"));
    }

    //in the book, it assumes theres a isSubstring method
    //I will just use .contains()
    static boolean isRotation(String s1, String s2){


        if(s1.length() == s2.length()){
            //think of the division of the string as xy
            //ex. erbottle = x, wat = y, whatever the rotation looks like it will always be a substring of xyxy
            if((s1+s1).contains(s2)){
                return true;
            }
        }

        return false;
    }
}
