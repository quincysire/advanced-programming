package Lecture4_interfaces_abstract_classes;

class InvalidDepositAmountException extends Exception {
    public InvalidDepositAmountException(String message) {
        super(message);
    }
}
