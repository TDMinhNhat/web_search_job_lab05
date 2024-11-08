package dev.skyherobrine.app.frontend.controllers.admin;

import dev.skyherobrine.app.backend.enums.SkillType;
import dev.skyherobrine.app.backend.models.Skill;
import dev.skyherobrine.app.frontend.models.SkillModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin-fe/skill")
public class SkillController {

    @Autowired
    private SkillModel sm;

    @PostMapping
    public ModelAndView addSkill(
            @RequestParam("inputSkillName") String skillName,
            @RequestParam("inputSkillDescription") String skillDescription,
            @RequestParam("inputSkillType") String skillType,
            ModelAndView mv
    ) {
        mv.setViewName("redirect:/admin-fe/skill");

        Skill skill = new Skill(skillDescription, skillName, SkillType.valueOf(skillType));
        sm.addSkill(skill);
        return mv;
    }
}
