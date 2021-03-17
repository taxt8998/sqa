package model;

import java.util.Date;

public class Loan {
    private int id;
    private LoanType loanType;
    private Account account;
    private Branch branch;
    private double amount;
    private String mortgate;
    private Date startDate;
    private Date endDate;
    private double curRate;
    private int duration;

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", loanType=" + loanType +
                ", account=" + account +
                ", branch=" + branch +
                ", amount=" + amount +
                ", mortgate='" + mortgate + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", curRate=" + curRate +
                ", duration=" + duration +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMortgate() {
        return mortgate;
    }

    public void setMortgate(String mortgate) {
        this.mortgate = mortgate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getCurRate() {
        return curRate;
    }

    public void setCurRate(double curRate) {
        this.curRate = curRate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Loan(int id, LoanType loanType, Account account, Branch branch, double amount, String mortgate, Date startDate, Date endDate, double curRate, int duration) {
        this.id = id;
        this.loanType = loanType;
        this.account = account;
        this.branch = branch;
        this.amount = amount;
        this.mortgate = mortgate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.curRate = curRate;
        this.duration = duration;
    }

    public Loan() {
    }
}
