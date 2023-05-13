public class StringWrapper{
    
    public String str = "Hello";


    public static void main (String [] args){
        String str = "GNU";
        StringWrapper sw1 = new StringWrapper();
        sw1.str = str;
        StringWrapper sw2 = new StringWrapper();
        sw2.str = sw2.str + sw1.str + str;
        System.out.println(str);
        System.out.println(sw1.str);
        System.out.println(sw2.str);
    }
}


    
