package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
import java.util.UUID;

public abstract class BaseTransaction implements TransactionInterface {
    private final double amount;  // Changed to double for better precision with monetary values
    private final Calendar date;
    private final String transactionID;

    /**
     * Lecture1_adt.TransactionInterface Constructor
     * @param amount in a double (representing the transaction amount)
     * @param date: Not null, and must be a Calendar object
     * @return void
     * Initializes the fields and attributes of a transaction
     * Creates an object of this
     */
    public BaseTransaction(double amount, @NotNull Calendar date)  {
        this.amount = amount;
        this.date = (Calendar) date.clone();
        this.transactionID = UUID.randomUUID().toString();  // Use UUID for unique transaction ID
    }

    /**
     * getAmount()
     * @return double
     */
    public double getAmount() {
        return amount; // Return the amount as a double for monetary values
    }

    /**
     * getDate()
     * @return Calendar object
     */
    public Calendar getDate() {
        return (Calendar) date.clone();  // Defensive copying to prevent external modifications
    }

    /**
     * getTransactionID()
     * @return String
     */
    public String getTransactionID() {
        return transactionID;  // Return the unique transaction ID
    }

    /**
     * Abstract method to print transaction details
     */
    public abstract void printTransactionDetails();

    /**
     * Abstract method to apply the transaction to a bank account
     * @param ba BankAccount object to apply the transaction to
     */
    public abstract void apply(BankAccount ba);
}
