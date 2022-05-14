package aut.utcluj.isp.ex4;


import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author stefan
 */
public class AirplaneTicketController {
    /**
     * Default number of tickets when a new instance is created
     */
    public static final int DEFAULT_NUMBER_OF_TICKETS = 10;
    private List<AirplaneTicket> tickets;

    public AirplaneTicketController() {
        this.tickets = new ArrayList<>();
        generateTickets();
    }

    /**
     * Generate default tickets
     */
    private void generateTickets() {
        for (int i = 0; i < DEFAULT_NUMBER_OF_TICKETS; i++) {
            String destination;
            Double price;

            if (i < 3) {
                destination = "Cluj-Napoca";
                price = 10d;
            } else if (i < 6) {
                destination = "Baia Mare";
                price = 20d;
            } else {
                destination = "Timisoara";
                price = 15d;
            }

            final AirplaneTicket airplaneTicket = new AirplaneTicket("ID-" + i, price, destination);
            airplaneTicket.setStatus(TicketStatus.NEW);

            tickets.add(airplaneTicket);
        }
    }

    public List<AirplaneTicket> getTickets() {
        return tickets;
    }

    /**
     * Get ticket details by ticket id
     *
     * @param ticketId - unique ticket id
     * @return
     * @apiNote: this method should throw {@link NoTicketAvailableException} exception if ticket not found
     */
    public AirplaneTicket getTicketDetails(final String ticketId) {
        //throw new UnsupportedOperationException("Not supported yet.");
         for(AirplaneTicket t: tickets){
             if(t.getId().equals(ticketId)){
                 return t;
             }
         }
         throw new NoTicketAvailableException();
    }

    /**
     * Buy ticket with specific destination
     * Ticket information should be updated: customer name and status {@link TicketStatus#ACTIVE}
     *
     * @param destination - destination
     * @param customerId  - customer name
     * @return
     * @apiNote: this method should throw the following exceptions:
     * {@link NoDestinationAvailableException} - if destination not supported by AirplaneTicketController
     * {@link NoTicketAvailableException} - if destination exists but no ticket with NEW status available
     */
    public void buyTicket(final String destination, final String customerId) {
        //throw new UnsupportedOperationException("Not supported yet.");
        boolean ok = false;
         for(AirplaneTicket t: tickets){
             if(t.getDestination().equals(destination) && t.getStatus() != TicketStatus.ACTIVE){
                 t.setStatus(TicketStatus.ACTIVE);
                 t.setCustomerId(customerId);
                 ok = true;
                 break;
             }
             
         }
         if(ok==false){
            throw new NoTicketAvailableException();
         }
    }
    

    /**
     * Cancel specific ticket
     * Status of the ticket should be set to {@link TicketStatus#CANCELED}
     *
     * @param ticketId - unique ticket id
     * @return
     * @apiNote: this method should throw the following exceptions:
     * {@link NoTicketAvailableException} - if ticket with this id does not exist
     * {@link TicketNotAssignedException} - if ticket is not assigned to any user
     */
    public void cancelTicket(final String ticketId) {
        //throw new UnsupportedOperationException("Not supported yet.");
        boolean ok = false;
         for(AirplaneTicket t: tickets){
             if(t.getId().equals(ticketId)){
                 t.setStatus(TicketStatus.CANCELED);
                 ok = true;
             }
         }
         if(ok==false){
             throw new NoTicketAvailableException();
         }
    }

    /**
     * Change ticket customer name by specific ticket id
     *
     * @param ticketId   - unique ticket id
     * @param customerId - unique customer name
     * @return
     * @apiNote: this method should throw the following exceptions:
     * {@link NoTicketAvailableException} - if ticket with this id does not exist
     * {@link TicketNotAssignedException} - if ticket is not assigned to any user
     */
    public void changeTicketCustomerId(final String ticketId, final String customerId) {
        //throw new UnsupportedOperationException("Not supported yet.");
        boolean ok = false;
        for(AirplaneTicket t: tickets){
            if(t.getId().equals(ticketId)){
                if(t.getCustomerId()==null){
                    throw new TicketNotAssignedException();
                } 
                t.setCustomerId(customerId);
                ok =true;
                 
            }
      
        }
        if(ok ==false){
                 throw new NoTicketAvailableException();
        }
    }
    /**
     * This method should filter all tickets by provided status.
     * An empty list should be returned if no tickets available with desired status
     *
     * @param status - ticket status
     * @return
     */
    public List<AirplaneTicket> filterTicketsByStatus(final TicketStatus status) {
        //throw new UnsupportedOperationException("Not supported yet.");
    List<AirplaneTicket> result = new ArrayList<>();
        for(AirplaneTicket t: tickets){
            if(t.getStatus()==status){
                result.add(t);
            }
        }
        return result;
    
    }

    /**
     * Return the tickets grouped by customer id
     *
     * @return dictionary where the key is the customer name and the value is a list of tickets for that customer
     * @apiNote: only tickets with available name should be returned
     */
    public Map<String, List<AirplaneTicket>> groupTicketsByCustomerId() {
        //throw new UnsupportedOperationException("Not supported yet.");
        Map<String, List<AirplaneTicket>> result = new HashMap<>();
        List<String> customers = new ArrayList<>(); 
        for(AirplaneTicket t: tickets){
            if(!customers.contains(t.getCustomerId())){
                customers.add(t.getCustomerId());
                List<AirplaneTicket> custTickets = new ArrayList<>();
                for(AirplaneTicket t2 : tickets){
                    if(t2.getCustomerId().equals(t.getCustomerId())){
                        custTickets.add(t2);
                    }
                }
                result.put(t.getCustomerId(), custTickets);
            }
                
        }
        return result;
    }
}
