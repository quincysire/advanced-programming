package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

class DepositTransaction extends BaseTransaction {

    /**
     * Constructor for DepositTransaction
     * @param amount The amount to be deposited
     * @param date The date of the transaction (must not be null)
     */
    public DepositTransaction(double amount, @NotNull Calendar date){
        super(amount, date);
    }

    /**
     * Check if the deposit amount is valid (positive amount)
     * @param amt The amount to be deposited
     * @return boolean Returns true if the deposit amount is valid (greater than or equal to zero), false otherwise
     */
    private boolean checkDepositAmount(double amt){
        return amt >= 0;
    }

    /**
     * Print the transaction details
     */
    @Override
    public void printTransactionDetails(){
        System.out.println("Deposit Transaction: " + this.toString());
    }

    /**
     * Apply the deposit transaction to a BankAccount
     * @param ba The BankAccount object to apply the deposit to
     */
    @Override
    public void apply(BankAccount ba){
        if (checkDepositAmount(getAmount())) {
            double currentBalance = ba.getBalance();
            double newBalance = currentBalance + getAmount();
            ba.setBalance(newBalance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
}
