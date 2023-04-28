package com.driver;

public class SavingsAccount extends BankAccount {
    double rate;
    double maxWithdrawalLimit;
    private int nWithDraws;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name, balance, 0);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;
        this.nWithDraws = 0;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void withdraw(double amount) throws Exception {

        if (nWithDraws > this.maxWithdrawalLimit) {
            throw new Exception("Maximum Withdraw Limit Exceed");
        }

        if (amount > super.getBalance()) {
            throw new Exception("Insufficient Balance");
        }

        super.setBalance(super.getBalance() - amount);
        nWithDraws++;
    }

    public double getSimpleInterest(int years) {
        // Return the final amount considering that bank gives simple interest on
        // current amount
        return super.getBalance() + rate * years * super.getBalance();

    }

    public double getCompoundInterest(int times, int years) {
        // Return the final amount considering that bank gives compound interest on
        // current amount given times per year
        return super.getBalance() * Math.pow(1 + rate / times, years);
    }
}
