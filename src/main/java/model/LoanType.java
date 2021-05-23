package model;

import java.util.Objects;

public class LoanType {
    private int id;
    private String name;
    private String description;
    private double rate;
    private int duration;

    @Override
    public String toString() {
        return "LoanType{" + 
                "id=" + id + 
                ", name=" + name + 
                ", description=" + description + 
                ", rate=" + rate + 
                ", duration=" + duration + '}';
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

    public LoanType(int id, String name, String description, double rate, int duration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rate = rate;
        this.duration = duration;
    }

    public LoanType(String name, String description, double rate, int duration) {
        this.name = name;
        this.description = description;
        this.rate = rate;
        this.duration = duration;
    }

    

    public LoanType() {
        super();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LoanType other = (LoanType) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.rate) != Double.doubleToLongBits(other.rate)) {
            return false;
        }
        if (this.duration != other.duration) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
    
    
}
