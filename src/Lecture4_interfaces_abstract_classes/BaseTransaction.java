package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

/**
 * BaseTransaction class to represent a general financial transaction.
 * The transaction contains details such as amount, date, and a generated transaction ID.
 * This class is intended to be extended by other transaction types.
 *
 * @param amount - The amount of the transaction (must be positive).
 * @param date - The date the transaction occurred (cannot be null).
 *
 * @return String - The generated unique transaction ID.
 *
 * @throws NullPointerException - if the date parameter is null.
 * @see DepositTransaction
 * @see WithdrawalTransaction
 * @author Quincy Sire
 */
public class BaseTransaction {
    private final double amount;
    private final Calendar date;
    private final String transactionID;

    public BaseTransaction(double amount, @NotNull Calendar date) {
        if (date == null) {
            throw new NullPointerException("Date cannot be null.");
        }
        this.amount = amount;
        this.date = (Calendar) date.clone(); // Defensive copy
        this.transactionID = generateTransactionID(date);
    }

    private String generateTransactionID(Calendar date) {
        int uniq = (int) (Math.random() * 10000);
        return date.getTime().toString() + "-" + uniq;
    }

    public double getAmount() {
        return amount;
    }

    public Calendar getDate() {
        return (Calendar) date.clone(); // Defensive copy
    }

    public String getTransactionID() {
        return transactionID;
    }

    // Default implementation
    public void app() {
        System.out.println("Default transaction behavior in BaseTransaction");
    }

    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + date.getTime());
    }

    public void apply(BankAccount ba) {
        System.out.println("Applying default transaction...");
    }
}
