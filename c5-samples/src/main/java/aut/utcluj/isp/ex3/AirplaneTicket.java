package aut.utcluj.isp.ex3;

/**
 * @author stefan
 */
public class AirplaneTicket {
    private String id;
    private Double price;
    private String destination;

    public AirplaneTicket(String id, Double price, String destination) {
        //throw new UnsupportedOperationException("Not supported yet.");
       this.destination = destination;
       this.id = id;
       this.price = price;
    }

    public String getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public String getDestination() {
        return destination;
    }
     public void setDestination(String destination){
        this.destination = destination;
    }
}
