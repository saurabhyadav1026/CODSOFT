
import java.util.*;

public class Atm {

    static User_account atm_holder_account = null;
    static Bank_account_control bank;

    public static void main(String[] args) {
        bank = new Bank_account_control(); // for bank which control all the accounts
                                         
        Scanner sc = new Scanner(System.in);



          /// loop for showing welcome interface
        while (true) {

            System.out.println(
                    " \n \n******************************************************************************************\n\n \t\t\t\tWelcome to ATM \n\n******************************************************************************************");
            atm_holder_account = bank.account_verification(sc);
            if (atm_holder_account == null)
                continue;

            System.out.print(
                    "\nEnter 1 for Withdrawal \n Enter 2 for Deposit \n Enter 3 for Balance Enquiry \n Enter 4 for Changing Pin\n Press any other key for exit.\nEnter:  ");

            char n = sc.next().charAt(0);
            sc.nextLine();

            switch (n) {
                case '1':                                                        // for withdrawal
                    System.out.print("\n Enter withdrawal amount:  ");
                    int amount = 15;
                    try {
                        amount = sc.nextInt();
                        sc.nextLine();
                    } catch (Exception e) {
                        System.out.println("\nInvalid amount, Try again.");
                        break;
                    }

                    if (withdrawal(amount)) {
                        check_balance(sc);
                        break;
                    }

                case '2':                                                       // for deposit
                    System.out.print("\n Enter Deposit amount:  ");
                    int d_amount = 15;
                    try {
                        d_amount = sc.nextInt();
                        sc.nextLine();
                    } catch (Exception e) {
                        System.out.println("\nInvalid amount, try again.");
                        break;
                    }
                    if (deposit(d_amount)) {
                        check_balance(sc);
                        break;
                    } 

                case '3':                                                       // for balance enquiry
                    balance_inquiry();
                    break; 
                case '4':                                                       // for pin changing
                    change_pin(sc);
                    break; 
                default:
                    break;

            }

            System.out.println(
                    "\nPlease take your card. \n\n*************************************    Thank You   *************************************");
        }

    }

                     // check balance on request after withdrawal or deposit                        
    static void check_balance(Scanner sc) {
        System.out.print(" \n\n Enter 1 for balance enquiry else press any other key for exit:  ");
        char temp = sc.next().charAt(0);
        sc.nextLine();
        if (temp == '1')
            balance_inquiry();
    }

    static boolean withdrawal(int amount) {
        if ((atm_holder_account.dis_balance() - amount) > 500) {
            if (amount % 100 == 0) {
                atm_holder_account.withdrawal_balance(amount);
                System.out.println("\nRs. " + amount
                        + " is successfully withdrawal from your account. \n Collect your cash. ");

            } else {
                System.out.print("\n Enter amount in multiple of 100. \n Enter:  ");
                return false;
            }
        }

        else {
            System.out.println("\nYour account balance is not sufficient for this transactions");
        }
        return true;
    }

    static boolean deposit(int amount) {
        if (amount % 100 == 0) {
            atm_holder_account.deposit_balance(amount);
            System.out.println(" \nRs. " + amount + " is successfully deposit in your account.");
            return true;
        } else
            return false;

    }

    static void balance_inquiry() {

        System.out.println("\nyour balance is: " + atm_holder_account.dis_balance());
        return;

    }

    static void change_pin(Scanner sc) {
        atm_holder_account.update_pin(sc);
        return;
    }

}

// class for control all customer's bank accounts

class Bank_account_control {
    User_account[] customer = new User_account[50];

    Bank_account_control() {
        for (int i = 0; i < 50; i++) {
            customer[i] = new User_account(i);
        }

    }

    User_account account_verification(Scanner sc) {

        int i;
        System.out.print("\n Enter account number:"); // for input of account number

        String ac_no = sc.nextLine();

        for (i = 0; i < customer.length; i++) { // loop for checking account number
            if (customer[i].dis_account_no().equals(ac_no)) {

                if (customer[i].dis_atm_status().equals("blocked")) { // for checking atm status
                    System.out
                            .println("\nYou had 3 incorrect attempt ,So your account is temporary blocked for 24 hours");
                    System.out.println("\n******************************************************************************************");

                    return null;
                }
                System.out.print("\n Enter pin:"); // for input of pin

                int n = 0; // counter to checking pin attempts
                while (n < 3) {
                    String pin_ = sc.nextLine(); // for input of pin

                    if (customer[i].dis_pin().equals(pin_)) { // pin verification
                        System.out.println("\nAccount verification successfully");
                        System.out.println(
                                "\n\n******************************************************************************************\n\n");
                        System.out.println("\n Hello! " + customer[i].dis_name() + "");

                        return customer[i];
                    }
                    n++;
                    if (n < 3)
                        System.out.println("\n"+n + " Attempt Incorrect pin, try again");
                }
                System.out.println("\n 3 incorrect attempt, your account is temporary blocked for 24 hours");
                customer[i].change_atm_status("blocked");
                System.out.println("\n Please take your card.\n\n*************************************    Thank You   *************************************");

                return null;

            }

        }
        System.out.println("\n Incorrect account number try again");

        return null;
    }

}

// class for customer bank account details
class User_account {

    private String account_no;
    private int balance;
    private String pin;
    private String name;
    private String account_type;
    private String atm_status;

    User_account(int n) {
        this.atm_status = "active";
        this.pin = "100" + n;
        this.account_type = "saving account";
        this.account_no = "9900" + n;
        this.name = "customer_" + n;
        this.balance = 5000;
    }

    void deposit_balance(int amount) {
        this.balance += amount;
    }

    void withdrawal_balance(int amount) {
        this.balance -= amount;
    }

    void update_pin(Scanner sc) {

        int n = 0;
        while (n < 3) {
            System.out.print("\n enter your old pin");

            String old_pin = sc.nextLine();
            System.out.print("\n enter your new pin");
            String new_pin = sc.nextLine();
            System.out.print("\nConfirm  your  pin");
            String confirm_pin = sc.nextLine();

            if (this.pin.equals(old_pin)) {
                if (new_pin.equals(confirm_pin)) {
                    this.pin = new_pin;
                    System.out.println("\nPin changed successfully");
                    return;
                } else {
                    System.out.println("\nConfirm pin did not match. Try again");
                }
            } else
                System.out.println("\nold pin is not matched.Try again.");
        }
        System.out.println("\n Too invalid attempt.\n Your card is temporary blocked.");
        change_atm_status("blocked");
        return;
    }

    int dis_balance() {
        return this.balance;
    }

    String dis_pin() {
        return this.pin;
    }

    String dis_account_no() {
        return this.account_no;
    }

    String dis_name() {
        return this.name;
    }

    String dis_account_type() {
        return this.account_type;
    }

    String dis_atm_status() {
        return this.atm_status;
    }

    void change_atm_status(String new_status) {
        this.atm_status = new_status;
    }
}