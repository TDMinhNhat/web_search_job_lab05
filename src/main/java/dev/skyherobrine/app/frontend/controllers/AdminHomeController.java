package dev.skyherobrine.app.frontend.controllers;

import dev.skyherobrine.app.backend.enums.SkillType;
import dev.skyherobrine.app.backend.models.Candidate;
import dev.skyherobrine.app.frontend.models.AdminHomeModel;
import dev.skyherobrine.app.frontend.models.CandidateModel;
import dev.skyherobrine.app.frontend.models.CompanyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin-fe")
public class AdminHomeController {

    @Autowired
    private AdminHomeModel ahm;
    @Autowired
    private CandidateModel cm;
    @Autowired
    private CompanyModel cpm;

    @GetMapping("/skill")
    public ModelAndView directToSkillManagement(ModelAndView mv) {
        mv.addObject("skillTypes", Arrays.stream(SkillType.values()).toList());
        mv.addObject("skills", ahm.getAllSkills());
        mv.setViewName("admin/skill");
        return mv;
    }

    @GetMapping("/candidate/{page}")
    public ModelAndView directToCandidateManagement(ModelAndView mv, @PathVariable("page") String page) {
        mv.setViewName("admin/candidate");

        List<Candidate> candidates = ahm.getAllCandidates();
        int pageSize = candidates.size() / 10;

        List<String> pages = new ArrayList<>();
        for(int i = 0; i <= pageSize; ++i) {
            pages.add((i + 1) + "");
        }

        mv.addObject("candidates", cm.getCandidatesForPage(Integer.parseInt(page) == 0 ? 0 : Integer.parseInt(page) - 1));
        mv.addObject("pages", pages);
        return mv;
    }

    @GetMapping("/company")
    public ModelAndView directToCompanyManagement(ModelAndView mv) {
        mv.setViewName("admin/company");
        mv.addObject("companies", cpm.getAllCompanies());
        return mv;
    }
}
