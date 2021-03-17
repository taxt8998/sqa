package model;

import java.util.Date;

public class Customer extends User{
    public Customer() {
    }

    public Customer(int id, String name, Date birth, String role, String address, String username, String password) {
        super(id, name, birth, role, address, username, password);
    }
}
