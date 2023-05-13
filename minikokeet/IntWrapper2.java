class IntWrapper2 {

    public int val = 0;

    public void inc(int amount){
        val+=amount;
    }

    public void dec(int amount){
        val-=amount;
    }

    public static void main (String [] args){
        IntWrapper2 iw1 = new IntWrapper2();
        IntWrapper2 iw2 = new IntWrapper2();
        for(int i = 0; i <= 5; i++)
        {
            iw2.dec(1);
            iw1.inc(iw2.val);
        }
        iw2.dec(10);

        System.out.println(iw1.val);
    }
}
