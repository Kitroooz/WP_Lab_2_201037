package mk.ukim.finki.lab_1_201037.model;

import lombok.Data;

@Data
public class TicketOrder {

    String movieTitle;
    String clientName;
    String clientAddress;
    Long numberOfTickets;

    public TicketOrder() {
    }

    public TicketOrder(String movieTitle, String clientName, String clientAddress, Long numberOfTickets) {
        this.movieTitle = movieTitle;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.numberOfTickets = numberOfTickets;
    }
}

