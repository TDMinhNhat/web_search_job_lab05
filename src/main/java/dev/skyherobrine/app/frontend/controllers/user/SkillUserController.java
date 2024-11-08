package dev.skyherobrine.app.frontend.controllers.user;

import dev.skyherobrine.app.backend.enums.CandidateRole;
import dev.skyherobrine.app.backend.models.Candidate;
import dev.skyherobrine.app.backend.models.JobSkill;
import dev.skyherobrine.app.backend.models.Skill;
import dev.skyherobrine.app.frontend.models.JobSkillModel;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user-fe/skill")
public class SkillUserController {

    @Autowired
    private JobSkillModel jsm;

    @GetMapping("/jobs/{id}")
    public ModelAndView getAllJobsBySkill(@PathVariable("id") String skillId, ModelAndView mv, HttpServletRequest request) {
        List<JobSkill> jobSkills = jsm.getAllJobsBySkill(Long.parseLong(skillId));
        CandidateRole role = CandidateRole.valueOf(request.getServletContext().getAttribute("role").toString());
        Candidate candidate = (Candidate) request.getServletContext().getAttribute("account_login");
        List<Skill> skills = (List<Skill>) request.getServletContext().getAttribute("skills");
        mv.addObject("role", role);
        mv.addObject("account_login", candidate);
        mv.addObject("skills", skills);
        mv.addObject("jobSkills", jobSkills);
        mv.setViewName("home");
        return mv;
    }
}
