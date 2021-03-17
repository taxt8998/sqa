package model;

public class LoanType {
    private int id;
    private String name;
    private String description;
    private double rate;

    @Override
    public String toString() {
        return "LoanType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rate=" + rate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public LoanType(int id, String name, String description, double rate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rate = rate;
    }

    public LoanType() {
    }
}
