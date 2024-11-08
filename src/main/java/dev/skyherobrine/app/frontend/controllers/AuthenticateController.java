package dev.skyherobrine.app.frontend.controllers;

import dev.skyherobrine.app.backend.models.Address;
import dev.skyherobrine.app.backend.models.Candidate;
import dev.skyherobrine.app.frontend.models.AuthenticateModel;
import dev.skyherobrine.app.frontend.models.SkillModel;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequestMapping("/auth-fe")
public class AuthenticateController {

    @Autowired
    private AuthenticateModel am;
    @Autowired
    private AuthenticateModel authenticateModel;
    @Autowired
    private SkillModel skillModel;

    @PostMapping("/login")
    public ModelAndView checkLogin(
            @RequestParam("inputEmail") String email,
            @RequestParam("inputPassword") String password,
            HttpServletRequest request
    ) {
        ModelAndView mv = new ModelAndView("home");
        Candidate target = am.checkLogin(email, password);
        request.getServletContext().setAttribute("account_login", target);
        request.getServletContext().setAttribute("role", target.getRole().toString());
        request.getServletContext().setAttribute("skills", skillModel.getAllSkills());
        mv.addObject("role", target.getRole().toString());
        mv.addObject("account_login", target);
        mv.addObject("skills", skillModel.getAllSkills());
        return mv;
    }

    @PostMapping("/register")
    public ModelAndView registerAccount(
            @RequestParam("inputFullName") String fullName,
            @RequestParam("inputPhone") String phone,
            @RequestParam("inputEmail") String email,
            @RequestParam("inputDob") String dob,
            @RequestParam("inputPassword") String password,
            @RequestParam("inputStreet") String street,
            @RequestParam("inputCity") String city,
            @RequestParam("inputCountry") String country,
            @RequestParam("inputNumber") String number,
            @RequestParam("inputZipcode") String zipCode,
            ModelAndView mv
    ) {
        String[] splitDate = dob.split("-");
        LocalDate date = LocalDate.of(Integer.parseInt(splitDate[0]), Integer.parseInt(splitDate[1]), Integer.parseInt(splitDate[2]));

        Address add = new Address(street, city, Short.parseShort(country), number, zipCode);

        Candidate candidate = new Candidate(
                date,
                email,
                fullName,
                phone,
                password,
                add
        );
        Address addResult = authenticateModel.registerAddress(add);
        candidate.setAddress(addResult);

        boolean result = authenticateModel.registerAccount(candidate);
        if(result) {
            mv.addObject("status", "Register success! Please login to continue");
            mv.setViewName("home");
        } else {
            mv.addObject("status", "Register failed! Please contact to administrator");
            mv.setViewName("register");
        }
        return mv;
    }
}
