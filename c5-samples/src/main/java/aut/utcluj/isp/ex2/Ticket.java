package aut.utcluj.isp.ex2;

import java.util.Objects;

/**
 * @author stefan
 */
public class Ticket {
    private String id;
    private String customerName;
    private Double price;

    public Ticket(String customerName, Double price) {
        this.id = String.valueOf(Math.random());
        this.customerName = customerName;
        this.price = price;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public Ticket(String id, String customerName, Double price) {
        //throw new UnsupportedOperationException("Not supported yet.");
        this.id = id;
        this.customerName = customerName;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Double getPrice() {
        return price;
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
        final Ticket other = (Ticket) obj;
        return Objects.equals(this.id,other.id);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.customerName);
        hash = 89 * hash + Objects.hashCode(this.price);
        return hash;
    }
}
