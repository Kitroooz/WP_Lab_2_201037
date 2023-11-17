package mk.ukim.finki.lab_1_201037.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.lab_1_201037.service.MovieService;
import mk.ukim.finki.lab_1_201037.service.ProductionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ticket")
class TicketOrderController {

    @PostMapping
    public String ticketOrder(Model model, HttpServletRequest req){
        model.addAttribute("ipAddress", req.getRemoteAddr());
        model.addAttribute("title",req.getParameter("title"));
        model.addAttribute("numTickets",req.getParameter("numTickets"));

        return "orderConfirmation";
    }

}
