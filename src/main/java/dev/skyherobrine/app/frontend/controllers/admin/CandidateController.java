package dev.skyherobrine.app.frontend.controllers.admin;

import dev.skyherobrine.app.backend.models.Candidate;
import dev.skyherobrine.app.frontend.models.CandidateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin-fe/candidate/detail")
public class CandidateController {

    @Autowired
    private CandidateModel cm;

    @GetMapping("{id}")
    public ModelAndView getCandidateDetail(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("admin/candidate/candidate-detail");
        Candidate target = cm.getCandidateDetail(id);
        mv.addObject("candidate", target);
        mv.addObject("candidate_skills", cm.getCandidateSkill(id));
        mv.addObject("candidate_experiences", cm.getCandidateExperiences(id));
        return mv;
    }
}
