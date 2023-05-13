public class IntWrapper {
    
    int val;

    public static void main (String [] args){
        IntWrapper iw1 = new IntWrapper();
        iw1.val = 2;
        IntWrapper iw2 = new IntWrapper();
        iw2.val = 5;

        System.out.println(iw1.val);
        System.out.println(iw2.val);
    }
}