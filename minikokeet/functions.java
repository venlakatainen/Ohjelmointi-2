

public class functions {
    
    public static void main(String[] args){
        String s = "11,22,33 \n 44,55,66 \n 77,88,99";
        System.out.println(hasEqualColumnWidth(s));
    }

    static boolean hasEqualColumnWidth(String s){
        String [] splitted = s.split("\n");
        
        int splitCount = splitted.length;

        int check = splitted[0].trim().length();
        Boolean answer = true;

        for (int i=0; i<splitCount; i++){

            String str = new String(splitted[i]);
            str = str.trim();

            if (str.length() != check ){
                answer = false;
                return answer;
            }
         
        }
        answer = true;
        return answer;
    }
}