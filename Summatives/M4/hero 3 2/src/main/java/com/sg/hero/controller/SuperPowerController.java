/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hero.controller;
import com.sg.hero.Dao.heroDaoImpl;
import com.sg.hero.Dao.superpowerDaoImpl;
import com.sg.hero.Dto.Superpower;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
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
public class SuperPowerController {
    @Autowired
    heroDaoImpl heroDao;
    @Autowired
    superpowerDaoImpl superpowerDao;
    Set<ConstraintViolation<Superpower>> violations = new HashSet<>();
    @GetMapping("superpowers")
    public String displaySuperpower(Model model) {
        List<Superpower> superpowers = superpowerDao.ReadAll();
        model.addAttribute("superpowers", superpowers);
        model.addAttribute("errors", violations);
        return "superpowers";
    }
    @PostMapping("addSuperpower")
    public String addSuperpower(String power) {
        Superpower superPower = new Superpower();
        superPower.setPower(power);
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(superPower);
        if (violations.isEmpty()) {
            superpowerDao.Create(superPower);
        }
        return "redirect:/superpowers";
    }
    @GetMapping("editSuperpower")
    public String editSuperpower(Integer id, Model model) {
        Superpower superpower = superpowerDao.ReadById(id);
        model.addAttribute("superpower", superpower);
        model.addAttribute("errors", violations);
        return "editSuperpower";
    }
    @PostMapping("editSuperpower")
    public String performEditPower(Superpower superPower) {
         Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(superPower);
        if (violations.isEmpty()) {
            superpowerDao.Update(superPower);
        }
    
        return "redirect:/superpowers";
    }
    @GetMapping("deleteSuperpower")
    public String deleteSuperpowers(Integer id) {
        superpowerDao.Delete(id);
        return "redirect:/superpowers";
    }
}