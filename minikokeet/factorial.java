public class factorial {

    class StringWrapper{
        public String str = "Hello";
    }
    String str = "GNU";
    StringWrapper sw1 = new StringWrapper();
    sw1.str = str;
    StringWrapper sw2 = new StringWrapper();
    sw2.str = sw2.str + sw1.str + str;
}

    
}