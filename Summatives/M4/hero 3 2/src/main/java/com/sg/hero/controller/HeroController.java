    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hero.controller;

import com.sg.hero.Dao.heroDaoImpl;
import com.sg.hero.Dao.superpowerDaoImpl;
import com.sg.hero.Dto.Hero;
import com.sg.hero.Dto.Superpower;
import static com.sun.org.apache.xalan.internal.lib.ExsltMath.power;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import static org.apache.tomcat.jni.Lock.name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author alanc
 */
@Controller
public class HeroController {

    @Autowired
    heroDaoImpl heroDao;
    @Autowired
    superpowerDaoImpl superpowerDao;

    Set<ConstraintViolation<Hero>> violations = new HashSet<>();

    @GetMapping("heroes")
    public String displayHeroes(Model model) {
        List<Hero> heroes = heroDao.ReadAll();
        List<Superpower> superpowers = superpowerDao.ReadAll();
        model.addAttribute("superpowers", superpowers);
        model.addAttribute("heroes", heroes);
        model.addAttribute("errors", violations);
        return "heroes";
    }

    @PostMapping("addHero")
    public String addHero(HttpServletRequest request) {
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        String memberType = request.getParameter("memberType");

        Hero hero = new Hero();

        String superpowerId = request.getParameter("superpowerId");

        hero.setName(name);
        hero.setDescription(description);
        Superpower superpower = superpowerDao.ReadById(Integer.parseInt(superpowerId));
        hero.setSuperpower(superpower);
        hero.setMembertype(memberType);
        
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(hero);

        if (violations.isEmpty()) {
            heroDao.Create(hero);
        }
        return "redirect:/heroes";
    }

    @GetMapping("deleteHero")
    public String deleteHero(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        heroDao.Delete(id);
        return "redirect:/heroes";
    }

    @GetMapping("editHero")
    public String editHero(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Hero hero = heroDao.ReadById(id);
        List<Superpower> powerList = superpowerDao.ReadAll();
        model.addAttribute("superpowers", powerList);
        model.addAttribute("hero", hero);
        model.addAttribute("errors", violations);
        return "editHero";
    }

    @PostMapping("editHero")
    public String performEditHero(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("heroId"));
        Hero hero = heroDao.ReadById(id);

        String power = request.getParameter("superpower");

        hero.setName(request.getParameter("heroName"));
        hero.setDescription(request.getParameter("heroDescription"));
        hero.setSuperpower(superpowerDao.ReadById(Integer.parseInt(power)));
        hero.setMembertype(request.getParameter("memberType"));
        
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(hero);

        if (violations.isEmpty()) {
            heroDao.Update(hero);
        }
       
        return "redirect:/heroes";
    }
}
