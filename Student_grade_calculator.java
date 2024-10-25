
// done 

import java.util.*;

public class Student_grade_calculator {

    // for getting valid integer number
    static int valid_int(Scanner sc,int t) {
        int i;
        try {
            i = sc.nextInt();
        } catch (Exception e) {
            sc.next();
            System.out.println("enter valid no:  ");
            return valid_int(sc,t);
        }

       if(i<0){
        System.out.println("enter valid no:  ");
        return valid_int(sc,t);
       }
       if(t==1&&i>100){System.out.println("Number should be less or equal to 100. Enter again:");
    return valid_int(sc, t);
    }
    return i;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n\n\n\n******************************************************************************************");
System.out.println("\t\t\tStudent Grade Calculator");
        System.out.println("\n\n hello! Sir/Ma'am, \nEnter your total subject no. :   "); // greeting msg
        int n = valid_int(sc,0);
        sc.nextLine();
        String[] sub_name = new String[n];
        int[] sub_mark = new int[n];
        int total = 0;
        String grade;

        System.out.print("Enter subject name and marks: ");
System.out.println("\n");
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + ". Subject Name: ");
            sub_name[i] = sc.nextLine().toUpperCase().trim().replaceAll("\\s+"," ");
     
            System.out.print("          Marks: ");
            sub_mark[i] = valid_int(sc,1);
            sc.nextLine();
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
                if(sub_name[i].length()<15){
                    while(sub_name[i].length()!=15){
                        sub_name[i] = sub_name[i] + " ";
                    }
                }
            }
        // displaying marks sheet
        System.out.println("******************************************************************************************");
       
       System.out.println("Your result is:    ");
        System.out.println("\n\n\t+-----------------------------------------------------------------+ ");
       System.out.println("\t|   S.No.\t\t Subject Name \t\t\t Marks\t  |");
      
      
        for (int i = 0; i < n; i++) {
            System.out.println("\t|   " + (i + 1) + ".\t\t\t " + sub_name[i] + "\t\t  " + sub_mark[i] + "\t  |   ");

        }
           System.out.println("\t| \t\t\t\t\t\t\t\t  |\n\t| \t\t\t\t\t\t\t\t  | ");
String total_percent=String.format("%.2f",(total *100.0)/ (n*100));
        System.out
                .println("\t|\t\t\tTotal marks  :  "+n*100+"\t\t\t  |\n\t|\t\t\tTotal Marks  :  " + total + "\t\t\t  |\n\t|\t\t\tPercentage   :  " + (total_percent) + "%\t\t\t  |\t\n\t|\t\t\tYour grade is: " + grade + "\t\t\t  |   ");
                System.out.println("\t+-----------------------------------------------------------------+ ");
       
                sc.close();
        System.out.println("\n\n*************************************    Thank You   *************************************");

          
    }

}
