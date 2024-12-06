package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {
    public WithdrawalTransaction(double amount, @NotNull Calendar date) {
        super(amount, date);
    }

    private boolean checkWithdrawalAmount(double amt) {
        return amt >= 0;
    }

    @Override
    public void app() {
        System.out.println("Withdrawal Transaction executed!");
    }

    @Override
    public void apply(BankAccount ba) {
        if (!checkWithdrawalAmount(getAmount())) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        double currentBalance = ba.getBalance();
        if (currentBalance >= getAmount()) {
            ba.setBalance(currentBalance - getAmount());
            System.out.println("Withdrawal of " + getAmount() + " applied successfully.");
        } else {
            System.out.println("Insufficient funds for withdrawal.");
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
