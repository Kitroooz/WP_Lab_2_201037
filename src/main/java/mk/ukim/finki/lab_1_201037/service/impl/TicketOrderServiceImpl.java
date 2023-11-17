package mk.ukim.finki.lab_1_201037.service.impl;

import mk.ukim.finki.lab_1_201037.model.TicketOrder;
import mk.ukim.finki.lab_1_201037.service.TicketOrderService;
import org.springframework.stereotype.Service;

@Service
public class TicketOrderServiceImpl implements TicketOrderService {

    public TicketOrder placeOrder(String movieTitle, String clientName, String address, long numberOfTickets)
    {
        return new TicketOrder(movieTitle, clientName, address, numberOfTickets);
    }
}

