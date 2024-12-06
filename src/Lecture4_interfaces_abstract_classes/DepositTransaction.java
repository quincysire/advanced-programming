package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

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
