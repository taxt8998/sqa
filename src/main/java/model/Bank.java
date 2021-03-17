package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Bank {
    private String name;
    private String hq;
    private ArrayList<Bank> listBank[];
    private ArrayList<User> listUser[];
    public Bank() {
    }

    public Bank(String name, String hq, ArrayList<Bank>[] listBank, ArrayList<User>[] listUser) {
        this.name = name;
        this.hq = hq;
        this.listBank = listBank;
        this.listUser = listUser;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", hq='" + hq + '\'' +
                ", listBank=" + Arrays.toString(listBank) +
                ", listUser=" + Arrays.toString(listUser) +
                '}';
    }

    public ArrayList<User>[] getListUser() {
        return listUser;
    }

    public void setListUser(ArrayList<User>[] listUser) {
        this.listUser = listUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHq() {
        return hq;
    }

    public void setHq(String hq) {
        this.hq = hq;
    }

    public ArrayList<Bank>[] getListBank() {
        return listBank;
    }

    public void setListBank(ArrayList<Bank>[] listBank) {
        this.listBank = listBank;
    }
}
