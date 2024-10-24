

// done 

import java.util.*;



public class Number_game {

    // greeting for game play
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char p;
        System.out.println(" \n\n\n\n******************************************************************************************");

        System.out.print("\t\thello! Lets, play the number guess game:--\n\n we have generate a random number between 1 to 100 guess it \n enter:   ");    // greeting
        do{play(sc);
            System.out.print("\n\nEnter 1 for play again else press another key. Enter: ");      // for playing again
            p=sc.next().charAt(0);
        }while(p!='1');
        System.out.println(" \n\n*************************************    Thank You & come again  *************************************");

          
sc.close();
    }


    // for game play
    static void play(Scanner sc) {
   

        int n, count = 0;
        int t;
        do {n = (int)(9999 * Math.random() / 100);} while (n <= 1);  //generating random number

        
// loop for guidance
        while (true) {

            t = valid_int(sc);
            count++;
            if (t < n)
                System.out.print("\nThe number is greater then it. enter again:  ");
            else if (t > n)
                System.out.print("\nThe number is smaller then it. enter again:  ");
            else {
                System.out.println(" \n\n*************************************    Hurrah! You Guessed It   *************************************");

          
                System.out.println(" \n\nyou have completed it with in  "+ count + "  time. \n  ");
                return;
            }
           
        }

    }

    // for getting only integer not character or special symbol
    static int valid_int(Scanner sc) {
       
        int i;
        try {
            i = sc.nextInt();
            } catch (Exception e) {sc.next();               // for clear the invalid input
                  System.out.println("enter valid integer between 1-100");
            return valid_int(sc);
        }
   
    return i;
    }

}