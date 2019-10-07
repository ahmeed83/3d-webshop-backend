package iq.threed.webshop.controller;

import iq.threed.webshop.dto.OrderDto;
import iq.threed.webshop.service.ShoppingCartService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/send-email")
public class SendEmailController {

    private final JavaMailSender javaMailSender;
    private final ShoppingCartService shoppingCartService;

    public SendEmailController(final JavaMailSender javaMailSender, final ShoppingCartService shoppingCartService) {
        this.javaMailSender = javaMailSender;
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping
    public void sendEmail(final @RequestBody OrderDto orderDto) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("ahmed83@me.com");

        msg.setSubject("I ROOOOOCK!");
        msg.setText("Order id is " + orderDto.getShoppingCartId() +
                " User id is " + orderDto.getUserId());
        shoppingCartService.deleteShoppingCart(orderDto.getShoppingCartId());
        javaMailSender.send(msg);
    }
}
