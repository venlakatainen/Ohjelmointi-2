class Name
{
    private String name;
    public Name(String nn)
    {
        name = nn;
    }
    public Name(Name other)
    {
        name = other.name;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String nn)
    {
        name = nn;
    }


    public static void main (String [] args){


        Name fn = new Name("John");
        Name ln = new Name("Smith");
        Person p = new Person(fn, ln);
        fn.setName("Peter");
        ln = new Name("Brown");
        
        p.print();
    }
}