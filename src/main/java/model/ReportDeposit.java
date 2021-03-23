package model;

import java.util.ArrayList;

public class ReportDeposit {
    private double amount;
    private int quantity;
    private ArrayList<Deposit> listDeposit;

    @Override
    public String toString() {
        return "ReportDeposit{" +
                "amount=" + amount +
                ", quantity=" + quantity +
                ", listDeposit=" + listDeposit +
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

    public ArrayList<Deposit> getListDeposit() {
        return listDeposit;
    }

    public void setListDeposit(ArrayList<Deposit> listDeposit) {
        this.listDeposit = listDeposit;
    }

    public ReportDeposit(double amount, int quantity, ArrayList<Deposit> listDeposit) {
        this.amount = amount;
        this.quantity = quantity;
        this.listDeposit = listDeposit;
    }

    public ReportDeposit() {
    }
}
