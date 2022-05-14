package aut.utcluj.isp.ex3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author stefan
 */
public class AirplaneTicketController {
    private final List<AirplaneTicket> tickets;

    public AirplaneTicketController() {
        //throw new UnsupportedOperationException("Not supported yet.");
        tickets = new ArrayList<>();
    }

    /**
     * Add new airplane ticket
     *
     * @param airplaneTicket - airplane ticket object
     */
    public void addNewTicket(final AirplaneTicket airplaneTicket) {
        //throw new UnsupportedOperationException("Not supported yet.");
        tickets.add(airplaneTicket);
    }

    /**
     * Get all tickets
     *
     * @return
     */
    public List<AirplaneTicket> getTickets() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return tickets;
    }

    /**
     * Return total number of tickets
     */
    public int getTotalNumberOfTickets() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return tickets.size();
    }

    /**
     * Remove a specific ticket by ticket id
     *
     * @param ticketId - unique ticket id
     */
    public void removeTicketById(final String ticketId) {
        //throw new UnsupportedOperationException("Not supported yet.");
        for(AirplaneTicket t: tickets){
            if(t.getId().equals(ticketId)){
                        tickets.remove(t);

            }
        }
    }

    /**
     * Update destination for a specific ticket
     *
     * @param ticketId    - unique ticket id
     * @param destination - new destination
     */
    public void updateTicketDestination(final String ticketId, final String destination) {
        //throw new UnsupportedOperationException("Not supported yet.");
        for(AirplaneTicket t: tickets){
            if(t.getId().equals(ticketId)){
               t.setDestination(destination);
            }
        }
    }

    /**
     * Filter airplane tickets with price between [minPrice, maxPrice]
     *
     * @param minPrice - ticket min prince
     * @param maxPrice - ticket max price
     * @return
     */
    public List<AirplaneTicket> filterTicketsBetweenMinMaxPrice(final Double minPrice, final Double maxPrice) {
        //throw new UnsupportedOperationException("Not supported yet.");
        List<AirplaneTicket> result = new ArrayList<>();
        for(AirplaneTicket t: tickets){
            if(t.getPrice()>= minPrice && t.getPrice()<= maxPrice){
                result.add(t);
            }
        }
        return result;
    }

    /**
     * Filter airplane tickets with price between [minPrice, maxPrice] and destination
     *
     * @param minPrice    - ticket min price
     * @param maxPrice    - ticket max price
     * @param destination - destination
     * @return
     */
    public List<AirplaneTicket> filterTicketsWithPriceAndDestination(final Double minPrice, final Double maxPrice, final String destination) {
        //throw new UnsupportedOperationException("Not supported yet.");
    List<AirplaneTicket> result = new ArrayList<>();
        for(AirplaneTicket t: tickets){
            if(t.getPrice()>= minPrice && t.getPrice()<= maxPrice && t.getDestination().equals(destination)){
                result.add(t);
            }
        }
        return result;
    }
}
