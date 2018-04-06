package LeetCode;

public class RotateString {
    public boolean rotateString(String A,String B){
        String C = A + A;
        if (C.contains(B) && (A.length()==B.length()))
            return true;
        else
            return false;
    }
}