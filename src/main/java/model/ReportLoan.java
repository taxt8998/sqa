package model;

import java.util.ArrayList;

public class ReportLoan {
    private double amount;
    private int quantity;
    ArrayList<Loan> listLoan;

    @Override
    public String toString() {
        return "ReportLoan{" +
                "amount=" + amount +
                ", quantity=" + quantity +
                ", listLoan=" + listLoan +
                '}';
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ArrayList<Loan> getListLoan() {
        return listLoan;
    }

    public void setListLoan(ArrayList<Loan> listLoan) {
        this.listLoan = listLoan;
    }

    public ReportLoan(double amount, int quantity, ArrayList<Loan> listLoan) {
        this.amount = amount;
        this.quantity = quantity;
        this.listLoan = listLoan;
    }

    public ReportLoan() {
    }
}
