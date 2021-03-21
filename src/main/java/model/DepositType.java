package model;

public class DepositType {
    private int id;
    private String name;
    private String description;
    private double rate;
    private int duration;

    @Override
    public String toString() {
        return "DepositType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rate=" + rate +
                ", duration=" + duration +
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public DepositType(int id, String name, String description, double rate, int duration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rate = rate;
        this.duration = duration;
    }

    public DepositType() {
        super();
    }
}
