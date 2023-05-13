class Person
{
    private Name first;
    private Name last;
    public Person(Name fn, Name ln)
    {
        first = new Name(fn);
        last = new Name(ln);
    }
    //public void print()
    //{
        //System.out.println(first + " " + last);
    //}

    public void print()
    {
        System.out.println(first.getName() + " " + last.getName());
    }
}