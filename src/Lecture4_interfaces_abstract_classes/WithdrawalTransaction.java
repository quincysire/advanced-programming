package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

/**
 * WithdrawalTransaction class extends BaseTransaction to apply a withdrawal transaction.
 * It ensures the withdrawal amount is valid and applies it to the bank account if sufficient funds are available.
 *
 * @param amount - The withdrawal amount (must be non-negative).
 * @param date - The date of the transaction (cannot be null).
 *
 * @return void - Applies the withdrawal to the bank account.
 *
 * @throws IllegalArgumentException - if the withdrawal amount is negative.
 * @throws InsufficientFundsException - if there are insufficient funds in the bank account.
 * @see BaseTransaction
 * @see ReversalTransaction
 * @author Quincy Sire
 */
public class WithdrawalTransaction extends BaseTransaction {
    public WithdrawalTransaction(double amount, @NotNull Calendar date) {
        super(amount, date);
    }

    private boolean checkWithdrawalAmount(double amt) {
        if (amt < 0) {
            throw new IllegalArgumentException("Withdrawal amount cannot be negative.");
        }
        return true;
    }

    @Override
    public void app() {
        System.out.println("Withdrawal Transaction executed!");
    }

    @Override
    public void apply(BankAccount ba) {
        if (checkWithdrawalAmount(getAmount())) {
            double currentBalance = ba.getBalance();
            if (currentBalance >= getAmount()) {
                ba.setBalance(currentBalance - getAmount());
                System.out.println("Withdrawal of " + getAmount() + " applied successfully.");
            } else {
                System.out.println("Insufficient funds for withdrawal.");
            }
        }
    }

    @Override
    public void printTransactionDetails() {
        System.out.println("Withdrawal Transaction Details:");
        super.printTransactionDetails();
    }

    public ReversalTransaction reverse(BankAccount ba) {
        if (getAmount() <= 0) {
            throw new IllegalArgumentException("Invalid reversal amount.");
        }

        double currentBalance = ba.getBalance();
        ba.setBalance(currentBalance + getAmount());
        return new ReversalTransaction(this.getAmount(), this.getDate());
    }
}
