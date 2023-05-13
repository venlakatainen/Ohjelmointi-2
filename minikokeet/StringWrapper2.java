class StringWrapper2 {
    String str = "Foo";
    
    public StringWrapper2(String istr){
        str = istr;
    }

    public static void main (String [] args){
        String str = "Bar";
        StringWrapper2 sw1 = new StringWrapper2(str);
        StringWrapper2 sw2 = new StringWrapper2(sw1.str + str);
        sw2.str += "Foo";
        System.out.println(sw2.str);
    }
}

