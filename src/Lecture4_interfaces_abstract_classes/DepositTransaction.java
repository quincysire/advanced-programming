package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

/**
 * DepositTransaction class extends BaseTransaction to apply a deposit transaction.
 * It ensures the deposit amount is valid and applies it to the bank account.
 *
 * @param amount - The deposit amount (must be non-negative).
 * @param date - The date of the transaction (cannot be null).
 *
 * @return void - Applies the deposit to the bank account.
 *
 * @throws IllegalArgumentException - if the deposit amount is negative.
 * @see BaseTransaction
 * @author Quincy Sire
 */
public class DepositTransaction extends BaseTransaction {
    public DepositTransaction(double amount, @NotNull Calendar date) {
        super(amount, date);
    }

    private boolean checkDepositAmount(double amt) {
        return amt >= 0;
    }

    @Override
    public void app() {
        System.out.println("Deposit Transaction executed!");
    }

    @Override
    public void apply(BankAccount ba) {
        if (!checkDepositAmount(getAmount())) {
            System.out.println("Invalid deposit amount.");
            return;
        }

        double currentBalance = ba.getBalance();
        ba.setBalance(currentBalance + getAmount());
        System.out.println("Deposit of " + getAmount() + " applied successfully.");
    }

    @Override
    public void printTransactionDetails() {
        System.out.println("Deposit Transaction Details:");
        super.printTransactionDetails();
    }
}
