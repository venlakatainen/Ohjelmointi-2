import java.util.Scanner;

class harj1teht2 {

    public static void main (String [] args){
           
        int count = 0;
        int max = 0;
        int min = 1;
        int input;
        double average = 0;
        int sum = 0;


        System.out.print("Syota kokonaisluku ");  
        Scanner userInput = new Scanner(System.in);  

        while ((input = userInput.nextInt()) > 0) {
            
            if (input > max){
                max = input;
            }
            if (input < min){
                min = input;
            }
            count ++;
            sum += input;
        }

        if ((input <= 0) && (count == 0)){
            max = min = input;
            count = 1;
            average = Math.abs(input);
            System.out.println("Lukuja syotetty " + count);
            System.out.println("Suurin arvo " + max);
            System.out.println("Pienin arvo " + min);
            System.out.println("Keskiarvo " + average);

        }

        else if (count > 0){
            average = sum/count;
            System.out.println("Lukuja syotetty " + count);
            System.out.println("Suurin arvo " + max);
            System.out.println("Pienin arvo " + min);
            System.out.println("Keskiarvo " + average);
        }

        else {
            System.out.println("Lukua ei syotetty");
        }
          
        
    }

}