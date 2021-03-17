package model;

import java.util.Date;

public class Employee extends User{
    private String position;

    public Employee() {
    }

    public Employee(int id, String name, Date birth, String role, String address, String username, String password) {
        super(id, name, birth, role, address, username, password);
    }

    public Employee(int id, String name, Date birth, String role, String address, String username, String password, String position) {
        super(id, name, birth, role, address, username, password);
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "position='" + position + '\'' +
                '}';
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
