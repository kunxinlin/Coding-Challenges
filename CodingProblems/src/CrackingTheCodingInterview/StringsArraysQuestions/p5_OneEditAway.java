package CrackingTheCodingInterview.StringsArraysQuestions;

//check if two string is just one edit (insert, replace, remove) away from each other
public class p5_OneEditAway {
    public static void main(String[] args) {
        System.out.println(oneEditAway("pale", "ple"));
        System.out.println(oneEditAway("pales", "pale"));
        System.out.println(oneEditAway("pale", "bale"));
        System.out.println(oneEditAway("pale", "bal")); //-> false
    }

    static boolean oneEditAway(String s1, String s2){
        if(s1.length() == s2.length()){
            return oneEditReplacement(s1, s2);
        }
        else if (s1.length() + 1 == s2.length()){
            //s1 is 1 shorter than s2, so an insertion
            return oneEditInsert(s1, s2);
        }
        else if (s1.length() - 1 == s2.length()){
            //s1 is 1 longer than s2, so an removal
            //but it the same as one insert into s2, so we just treat the 2nd string as the shorter one
            return oneEditInsert(s2, s1);
        }

        return false;
    }

    static boolean oneEditReplacement(String s1, String s2){
        boolean foundDifference = false;

        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(foundDifference){
                    return false;
                }
                foundDifference = true;
            }
        }

        return true;
    }

    //string s1 is 1 character shorter than s2
    static boolean oneEditInsert(String s1, String s2){
        int index1 = 0;
        int index2 = 0;

        while(index1 < s1.length() && index2 < s2.length()){
            if(s1.charAt(index1) != s2.charAt(index2)){
                if(index1 != index2){
                    //if the index is not equal, it means the index2 has already been incremented once
                    //so it would be more than just one mismatch, so it wont be one insert away.
                    return false;
                }
                //if first encounter of mismatch, then increment the index of the 2nd string
                //everything else after should be identical
                index2++;
            }else{

                //if the 2 char are same, then increment the index of both string
                index1++;
                index2++;
            }
        }

        return true;
    }
}
