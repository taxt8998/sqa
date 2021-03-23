package model;

import java.util.Date;

public class Deposit {
    private int id;
    private DepositType depositType;
    private Branch branch;
    private Account account;
    private double amount;
    private Date depositDate;
    private Date withdraw_date;
    private int duration;
    private double curRate;

    public Date getDepositDate() {
        return depositDate;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", depositType=" + depositType +
                ", branch=" + branch +
                ", account=" + account +
                ", amount=" + amount +
                ", depositDate=" + depositDate +
                ", withdraw_date=" + withdraw_date +
                ", duration=" + duration +
                ", curRate=" + curRate +
                '}';
    }

    public void setDepositDate(Date depositDate) {
        this.depositDate = depositDate;
    }

    public Date getWithdraw_date() {
        return withdraw_date;
    }

    public void setWithdraw_date(Date withdraw_date) {
        this.withdraw_date = withdraw_date;
    }

    public Deposit(int id, DepositType depositType, Branch branch, Account account, double amount, Date depositDate, Date withdraw_date, int duration, double curRate) {
        this.id = id;
        this.depositType = depositType;
        this.branch = branch;
        this.account = account;
        this.amount = amount;
        this.depositDate = depositDate;
        this.withdraw_date = withdraw_date;
        this.duration = duration;
        this.curRate = curRate;
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
        this.depositDate = date;
        this.duration = duration;
        this.curRate = curRate;
    }

    public Deposit() {
    }
}
