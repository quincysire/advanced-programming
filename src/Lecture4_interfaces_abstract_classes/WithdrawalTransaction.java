package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

/**
 * Represents a withdrawal transaction that deducts an amount from a bank account balance.
 */
public class WithdrawalTransaction extends BaseTransaction {

    /**
     * Constructor for WithdrawalTransaction.
     * @param amount the transaction amount
     * @param date the date of the transaction
     */
    public WithdrawalTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    /**
     * Checks if the deposit amount is valid (non-negative).
     * @param amt the amount to check
     * @return true if valid, false otherwise
     */
    private boolean checkDepositAmount(int amt) {
        return amt >= 0;
    }

    /**
     * Reverses the transaction, adding the amount back to the account balance.
     * @param ba the bank account to reverse the transaction on
     * @return true if the reversal is successful, false otherwise
     */
    public boolean reverse(BankAccount ba) {
        if (ba != null) {
            double newBalance = ba.getBalance() + getAmount();
            ba.setBalance(newBalance);
            System.out.println("Transaction reversed: " + this.toString());
            return true; // Reversal successful
        }
        return false; // Reversal failed
    }

    /**
     * Prints the details of the withdrawal transaction.
     */
    public void printTransactionDetails() {
        System.out.println("Withdrawal Transaction: " + this.toString());
    }

    /**
     * Applies the withdrawal to the given bank account, reducing its balance.
     * @param ba the bank account to apply the withdrawal to
     */
    public void apply(BankAccount ba) {
        double curr_balance = ba.getBalance();
        if (curr_balance > getAmount()) {
            double new_balance = curr_balance - getAmount();
            ba.setBalance(new_balance);
        }
    }
}
