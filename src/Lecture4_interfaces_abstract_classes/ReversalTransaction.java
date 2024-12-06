package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

/**
 * ReversalTransaction class extends BaseTransaction to reverse a previous transaction.
 * It allows the reversal of both deposit and withdrawal transactions.
 *
 * @param amount - The amount to be reversed (must be positive).
 * @param date - The date the reversal occurred (cannot be null).
 *
 * @return void - Applies the reversal to the bank account.
 *
 * @throws IllegalArgumentException - if the reversal amount is invalid.
 * @see BaseTransaction
 * @see WithdrawalTransaction
 * @author Quincy Sire
 */
public class ReversalTransaction extends BaseTransaction {

    private boolean isReversed = true;

    public ReversalTransaction(double amount, @NotNull Calendar date) {
        super(amount, date);
    }

    public void apply(BankAccount ba) {
        double currentBalance = ba.getBalance();
        double amountToReverse = getAmount();
        ba.setBalance(currentBalance + amountToReverse);
        System.out.println("Reversal of " + amountToReverse + " applied successfully.");
    }

    public void printTransactionDetails() {
        System.out.println("Reversal Transaction:");
        System.out.println("Amount: " + getAmount());
        System.out.println("Date: " + getDate().getTime());
        System.out.println("Transaction ID: " + getTransactionID());
        System.out.println("Reversed: " + (isReversed ? "Yes" : "No"));
    }
}