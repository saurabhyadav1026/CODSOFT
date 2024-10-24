
// done 

import java.util.*;

public class Student_grade_calculator {

    // for getting valid integer number
    static int valid_int(Scanner sc) {
        int i;
        try {
            i = sc.nextInt();
        } catch (Exception e) {
            sc.next();
            System.out.println("enter valid no:  ");
            return valid_int(sc);
        }

       
        return i;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n\n\n\n******************************************************************************************");
System.out.println("\t\t\tStudent Grade Calculator");
        System.out.println("\n\n hello! Sir/Ma'am, \nEnter your total subject no. :   "); // greetiing msg
        int n = valid_int(sc);
        String[] sub_name = new String[n];
        int[] sub_mark = new int[n];
        int total = 0;
        String grade;

        System.out.print("Enter subject name and marks: ");
System.out.println("\n");
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + ". Subject Name: ");
            sub_name[i] = sc.next();
            System.out.print("          Marks: ");
            sub_mark[i] = valid_int(sc);
            total += sub_mark[i];
        }

        // giving grade

        if ((total/n)>90)
            grade = "A+";
        else if ((total/n)>80)
            grade = "A";
        else if ((total/n)>70)
            grade = "B+";
        else if ((total/n)>60)
            grade = "B";
        else
            grade = "C";

            for (int i=0;i<sub_name.length;i++) {
                if(sub_name[i].length()<7){
                    while(sub_name[i].length()!=7){
                        sub_name[i] = sub_name[i] + " ";
                    }
                }
            }
        // displaying marksheet
        System.out.println("******************************************************************************************");

        System.out.println("Your result is:    \n\n\n\n\n  |   S.No.\t\t Subject Name \t\t Marks\t  |");

        for (int i = 0; i < n; i++) {
            System.out.println("  |   " + (i + 1) + ".\t\t " + sub_name[i] + "\t\t  " + sub_mark[i] + "\t  |   ");

        }
           System.out.println("------------------------------------------------------------ ");

        System.out
                .println("\n\n\t|\tTotal marks:  "+n*100+"\t|\n\t|\tTotal Marks:  " + total + "\t|\n\t|\tPercentage:  " + (total / n)
                        + "%\t|\t\n\t|\tYour grade is: " + grade + "\t|   ");
        sc.close();
        System.out.println("\n\n*************************************    Thank You   *************************************");

          
    }

}