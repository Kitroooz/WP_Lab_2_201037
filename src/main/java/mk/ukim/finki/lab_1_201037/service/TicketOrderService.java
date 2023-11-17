package mk.ukim.finki.lab_1_201037.service;

import mk.ukim.finki.lab_1_201037.model.TicketOrder;

public interface TicketOrderService {
    TicketOrder placeOrder(String movieTitle, String clientName, String address, long numberOfTickets);
}
