package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {
    public WithdrawalTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    private boolean checkDepositAmount(int amt) {
        if (amt < 0) {
            return false;
        } else {
            return true;
        }
    }

    // Method to reverse the transaction
    public boolean reverse(BankAccount ba) {
        if (ba != null) {
            double newBalance = ba.getBalance() + getAmount();
            ba.setBalance(newBalance);
            System.out.println("Transaction reversed: " + this.toString());
            return true; // Reversal successful
        }
        return false; // Reversal failed
    }

    // Method to print a transaction receipt or details
    public void printTransactionDetails() {
        System.out.println("Withdrawal Transaction: " + this.toString());
    }

    /*
    Opportunity for assignment: implementing different form of withdrawal
    */
    public void apply(BankAccount ba) {
        double curr_balance = ba.getBalance();
        if (curr_balance > getAmount()) {
            double new_balance = curr_balance - getAmount();
            ba.setBalance(new_balance);
        }
    }
}
