package model;

import java.util.Date;

public class Deposit {
    private int id;
    private DepositType depositType;
    private Branch branch;
    private Account account;
    private double amount;
    private Date date;
    private int duration;
    private double curRate;

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", depositType=" + depositType +
                ", branch=" + branch +
                ", account=" + account +
                ", amount=" + amount +
                ", date=" + date +
                ", duration=" + duration +
                ", curRate=" + curRate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DepositType getDepositType() {
        return depositType;
    }

    public void setDepositType(DepositType depositType) {
        this.depositType = depositType;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getCurRate() {
        return curRate;
    }

    public void setCurRate(double curRate) {
        this.curRate = curRate;
    }

    public Deposit(int id, DepositType depositType, Branch branch, Account account, double amount, Date date, int duration, double curRate) {
        this.id = id;
        this.depositType = depositType;
        this.branch = branch;
        this.account = account;
        this.amount = amount;
        this.date = date;
        this.duration = duration;
        this.curRate = curRate;
    }

    public Deposit() {
    }
}
