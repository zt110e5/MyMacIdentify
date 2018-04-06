import java.util.Scanner;

public class Main {
    public int VSStr(String str1,String str2){
        Scanner input1 = new Scanner(System.in);
        while (input1.hasNextLine()){
            str1 = input1.nextLine();
            str2 = input1.nextLine();
        }

        int result = 0;
        if (str1.length() == str2.length()){
            result += helper(str1,str2);
        }else {
            int index = 0;
            for (;index < str1.length()-str2.length()+1;index++){
                String str3 = str1.substring(index,index+str2.length());
                //System.out.println("str1: "+str3);
                //System.out.println("str2: " +str2);
                result += helper(str3,str2);
            }
        }
        return result;
    }



    public int helper(String str1,String str2){
        int result = 0;
        for (int i =0;i<str1.length();i++){
            if (str1.charAt(i) != str2.charAt(i))
                result += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Main m = new Main();
        String string1 = "aaabb";
        String string2 = "bab";
        int rel = m.VSStr(string1,string2);
        System.out.println(rel);
        String s3 = "aab";
        String s4 = "aba";
        int sre = m.VSStr(s3,s4);
        System.out.println(sre);
        System.out.println(Integer.MAX_VALUE);
    }
}
