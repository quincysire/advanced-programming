import Lecture1_adt.*; // Import all classes from Lecture1_adt package to be used in this client code

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.List;

public class Main {

    // Add this method for testing DepositTransaction
    public static void testDepositTransaction() {
        // Create a BankAccount object
        BankAccount myAccount = new BankAccount();

        // Create a Calendar object for the transaction date
        Calendar transactionDate = Calendar.getInstance();

        // Create a DepositTransaction with an invalid amount (negative)
        DepositTransaction deposit = new DepositTransaction(-100, transactionDate);

        // Attempt to apply the deposit to the account
        deposit.apply(myAccount);  // This will print: "Error: Deposit amount cannot be negative: -100.0"

        // Print the balance to verify that the deposit was not applied
        System.out.println("Current Balance: " + myAccount.getBalance());  // Balance should still be 0.0

        // Now test with a valid deposit amount
        DepositTransaction validDeposit = new DepositTransaction(1000, transactionDate);
        validDeposit.apply(myAccount);  // This will successfully apply the deposit
        System.out.println("Updated Balance after valid deposit: " + myAccount.getBalance());  // Balance should be 1000.0
    }

    // Test Transaction1 class
    public static void testTransaction1() {
        Calendar d1 = new GregorianCalendar(); // d1 is an Object [Objects are Reference types]
        Lecture1_adt.Transaction1 t1 = new Lecture1_adt.Transaction1(1000, d1); // amount and d1 are arguments

        System.out.println(t1.toString());
        System.out.println("Lecture1_adt.TransactionInterface Amount: \t " + t1.amount);
        System.out.println("Lecture1_adt.TransactionInterface Date: \t " + t1.date);
    }

    // Test Transaction2 class
    public static Transaction2 makeNextPayment(Transaction2 t) {
        Calendar d = t.getDate();
        d.add(Calendar.MONTH, 1);
        return new Transaction2(t.getAmount(), d);
    }

    public static void testTransaction2() {
        Calendar d1 = new GregorianCalendar();
        Lecture1_adt.Transaction2 t = new Lecture1_adt.Transaction2(1000, d1);
        Lecture1_adt.Transaction2 modified_t = makeNextPayment(t);

        System.out.println("\n\nState of the Object T1 After Client Code Tried to Change the Amount");
        System.out.println("Lecture1_adt.TransactionInterface Amount: \t " + modified_t.getAmount());
        System.out.println("Lecture1_adt.TransactionInterface Date: \t " + modified_t.getDate().getTime());

        System.out.println("\n\nHow does T2 Look Like?????");
        System.out.println("Lecture1_adt.TransactionInterface Amount: \t " + modified_t.getAmount());
        System.out.println("Lecture1_adt.TransactionInterface Date: \t " + modified_t.getDate().getTime());
    }

    // Test Transaction3 class
    public static List<Transaction3> makeYearOfPayments(int amount) throws NullPointerException {
        List<Transaction3> listOfTransaction3s = new ArrayList<Transaction3>();
        Calendar date = new GregorianCalendar(2024, Calendar.JANUARY, 3);

        for (int i = 0; i < 12; i++) {
            listOfTransaction3s.add(new Transaction3(amount, date));
            date.add(Calendar.MONTH, 1);
        }
        return listOfTransaction3s;
    }

    public static void testTransaction3() {
        List<Transaction3> allPaymentsIn2024 = makeYearOfPayments(1000);

        for (Transaction3 t3 : allPaymentsIn2024) {
            System.out.println("\n\n  ::::::::::::::::::::::::::::::::::::::::::::\n");
            System.out.println("Lecture1_adt.TransactionInterface Amount: \t " + t3.getAmount());
            System.out.println("Lecture1_adt.TransactionInterface Date: \t " + t3.getDate().getTime());
        }
    }

    // Test Transaction4 class
    public static List<Transaction4> makeYearOfPaymentsFinal(int amount) throws NullPointerException {
        List<Transaction4> listOfTransaction4s = new ArrayList<Transaction4>();
        Calendar date = new GregorianCalendar(2024, Calendar.JANUARY, 3);

        for (int i = 0; i < 12; i++) {
            listOfTransaction4s.add(new Transaction4(amount, date));
            date.add(Calendar.MONTH, 1);
        }
        return listOfTransaction4s;
    }

    public static void testTransaction4() {
        List<Transaction4> transactionsIn2024 = makeYearOfPaymentsFinal(1200);

        for (Transaction4 transact : transactionsIn2024) {
            System.out.println("\n\n  ::::::::::::::::::::::::::::::::::::::::::::\n");
            System.out.println("Lecture1_adt.TransactionInterface Amount: \t " + transact.getAmount());
            System.out.println("Lecture1_adt.TransactionInterface Date: \t " + transact.getDate().getTime());
        }
    }

    public static void main(String[] args) {
        // Uncomment the following lines to test the class which you would like to test

        // testTransaction1();
        // testTransaction2();
        // testTransaction3();
        // testTransaction4();

        testDepositTransaction();
    }
}
