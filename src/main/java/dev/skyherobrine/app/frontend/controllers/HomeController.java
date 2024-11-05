package dev.skyherobrine.app.frontend.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home-fe")
public class HomeController {

    @GetMapping("/admin")
    public String directToAdminPage() {
        return "admin/admin-home";
    }

    @GetMapping("/login")
    public String directToLogin() {
        return "login";
    }

    @GetMapping("/logout")
    public String directToLogout(HttpServletRequest request) {
        request.getServletContext().setAttribute("account_login", null);
        return "redirect:/";
    }
}
