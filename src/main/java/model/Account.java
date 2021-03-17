package model;

import java.util.Date;

public class Account {
    private int id;
    private Date openDate;
    private Customer customer;
    private CustomerType customerType;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", openDate=" + openDate +
                ", customer=" + customer +
                ", customerType=" + customerType +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Account(int id, Date openDate, Customer customer, CustomerType customerType) {
        this.id = id;
        this.openDate = openDate;
        this.customer = customer;
        this.customerType = customerType;
    }

    public Account() {
    }
}
