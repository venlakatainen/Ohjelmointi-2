import java.util.*;
import java.lang.*; 


public class hello {
    public static void main(String[] args){
        String s = "01:10"; 
        System.out.println(isValidTime(s));
    }

    static boolean isValidTime(String s){
        boolean isvalid = false;
        String [] time = s.split(":");
    
        if ((Integer.valueOf(time[0]) < 24) && (Integer.valueOf(time[0]) >= 0)){
            if ((Integer.valueOf(time[1]) < 60) && (Integer.valueOf(time[0]) >= 0)){
                isvalid = true;
                return isvalid;
            }
            else {
                isvalid = false;
                return isvalid;
            }
        }
        else {
            isvalid = false;
            return isvalid;
        }
        
    }

}
