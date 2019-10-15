package iq.threed.webshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller for the user.
 */
@RestController
@RequestMapping
public class UserController {

    /**
     * End point that been used by the customers.
     *
     * @return TODO:
     */
    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }

    /**
     * End point that been used by the admin.
     *
     * @return TODO:
     */
    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }
}
