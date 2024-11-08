package dev.skyherobrine.app.frontend.controllers;

import dev.skyherobrine.app.backend.models.Candidate;
import dev.skyherobrine.app.frontend.models.AuthenticateModel;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/auth-fe")
public class AuthenticateController {

    @Autowired
    private AuthenticateModel am;

    @PostMapping("/login")
    public ModelAndView checkLogin(
            @RequestParam("inputEmail") String email,
            @RequestParam("inputPassword") String password,
            HttpServletRequest request
    ) {
        ModelAndView mv = new ModelAndView("index");
        Candidate target = am.checkLogin(email, password);
        request.getServletContext().setAttribute("account_login", target);
        mv.addObject("role", target.getRole().toString());
        mv.addObject("account_login", target);
        return mv;
    }
}
