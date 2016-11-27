package com.emilyfroman.week_13;

/**
 * Created by Emily on 11/25/2016.
 */
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

class CheckingAccount {
    private int balance;
    private Semaphore permits = new Semaphore(1);

    public CheckingAccount(int intialBalance) {
        balance = intialBalance;
    }

    public int withdraw(int amount) {
        if (amount <= balance) {

            try {
                Thread.sleep((int) (Math.random() * 200 ));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            balance -= amount;
        }
        return balance;
    }
}

class AccountHolder implements Runnable {
    private String name;
    private CheckingAccount account;

    AccountHolder(String name, CheckingAccount account) {
        this.name = name;
        this.account = account;
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++) {
            int newBalance;
            synchronized (account) {
                newBalance = account.withdraw(10);
            }
            System.out.println(name + " tries to withdraw $10, balance: "
                    + newBalance);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        CheckingAccount account = new CheckingAccount(100);
        AccountHolder husband = new AccountHolder("Husband", account);
        AccountHolder wife = new AccountHolder("Wife", account);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(husband);
        executor.submit(wife);
    }
}