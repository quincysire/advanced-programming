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
     * @throws InvalidDepositAmountException if the deposit amount is negative
     */
    private void checkDepositAmount(double amt) throws InvalidDepositAmountException {
        if (amt < 0) {
            throw new InvalidDepositAmountException("Deposit amount cannot be negative: " + amt);
        }
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
        try {
            // Check if the deposit amount is valid
            checkDepositAmount(getAmount());

            // If valid, apply the transaction
            double currentBalance = ba.getBalance();
            double newBalance = currentBalance + getAmount();
            ba.setBalance(newBalance);
        } catch (InvalidDepositAmountException e) {
            // Handle the exception if deposit amount is invalid
            System.out.println("Error: " + e.getMessage());
        }
    }
}
