import java.util.Scanner;

class harj1teht1 {

    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);    
        
        System.out.print("Enter first name and last name separated by space");  
        String name = sc.nextLine();  
        System.out.println("Tervetuloa Java-ohjelmoinnin maailmaan " + name);  

        Scanner input = new Scanner(System.in);
        System.out.println("Press Enter to quit...");
        input.nextLine();
        
    }

}