public class Problem8_StringToInteger_atoi {
    public static void main(String[] args) {
        System.out.println(myAtoi(""));
        System.out.println(myAtoi(" "));
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("     -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
    }

    public static int myAtoi(String s) {
        //takes care of white space and empty string
        s = s.trim();
        if(s.isEmpty()) return 0;

        //for + -
        int sign = 1;
        //to iterate through the string
        int index = 0;
        //need double incase of overflow
        double result = 0;

        if(s.charAt(index) == '-'){
            sign = -1;
            index++;
        }else if(s.charAt(index) == '+'){
            index++;
        }


        //ex. 123
        //iter 1: result = 0x10 = 0 + 1 -> 1
        //iter 2: result = 1x10 = 10 + 2 -> 12
        //iter 3: result = 12x10 = 120 + 3 -> 123
        while(index < s.length() && s.charAt(index) - '0' >= 0 && s.charAt(index) - '0' <= 9){
            int digit = s.charAt(index) - '0';
            result = result*10 + digit;
            index++;
        }

        //add the sign
        result *= sign;

        //check for Integer overflow/underflow
        if(result > 0){
            return Math.min((int)result, Integer.MAX_VALUE);
        }else{
            return Math.max((int)result, Integer.MIN_VALUE);
        }
    }





/*    //kind of a first take/my approach
    //but its really long and slow and using bunch of Java crutches
    public int myAtoi(String s) {
        //takes care of white space
        s = s.trim();
        if(s.isEmpty()) return 0;

        //for + -
        boolean postive = true;


        int index = 0;
        if(s.charAt(index) == '-'){
            postive = false;
            index++;
        }else if(s.charAt(index) == '+'){
            index++;
        }

        String result = "";
        if(postive == false){
            result += "-";
        }


        while(index < s.length()){
            //get only digits
            if(Character.isDigit(s.charAt(index))){
                result = result + s.charAt(index);

                index++;
            }else{
                break;
            }
        }

        //for handling overflow
        double temp = 0;

        try{
            temp = Double.parseDouble(result);
        }
        catch(NumberFormatException e){
            return 0;
        }

        if(temp > Integer.MAX_VALUE)
        {
            return Integer.MAX_VALUE;
        }

        if(temp < Integer.MIN_VALUE)
        {
            return Integer.MIN_VALUE;
        }

        return (int)temp;
    }*/
}
