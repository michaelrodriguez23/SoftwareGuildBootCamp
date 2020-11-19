/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hero.controller;

import com.sg.hero.Dao.heroDaoImpl;
import com.sg.hero.Dao.organizationDaoImpl;
import com.sg.hero.Dto.Hero;
import com.sg.hero.Dto.Organization;
import com.sg.hero.Dto.Sighting;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
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
 * @author michaelrodriguez
 */
@Controller
public class OrganizationController {

    @Autowired
    heroDaoImpl heroDao;
    @Autowired
    organizationDaoImpl organizationDao;
    
        Set<ConstraintViolation<Organization>> violations = new HashSet<>();

    @GetMapping("organizations")
    public String displayOrganizations(Model model) {
        List<Organization> organizations = organizationDao.ReadAll();
        List<Hero> heroes = heroDao.ReadAll();
        model.addAttribute("organizations", organizations);
        model.addAttribute("heroes", heroes);
         model.addAttribute("errors", violations);
        return "organizations";
    }

    @PostMapping("addOrganization")
    public String addOrganization(Organization organization, HttpServletRequest request) {
        String[] heroIds = request.getParameterValues("heroId");
        List<Hero> heroes = new ArrayList<>();
        for (String heroId : heroIds) {
            heroes.add(heroDao.ReadById(Integer.parseInt(heroId)));
        }
        organization.setDescriptions(request.getParameter("descriptions"));
        organization.setName(request.getParameter("name"));
        organization.setStreet(request.getParameter("street"));
        organization.setCity(request.getParameter("city"));
        organization.setState(request.getParameter("state"));
        organization.setZip(request.getParameter("zipcode"));
        organization.setMemberType(request.getParameter("memberType"));
        
        organization.setHeroes(heroes);
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(organization);

        if (violations.isEmpty()) {
            organizationDao.Create(organization);

        }
        
  
        return "redirect:/organizations";
    }
    

    @GetMapping("organizationDetail")
    public String organizationDetail(Integer id, Model model) {
        Organization organization = organizationDao.ReadById(id);
        model.addAttribute("organization", organization);
        return "organizationDetail";
    }

    @GetMapping("deleteOrganization")
    public String deleteOrganization(Integer id) {
        organizationDao.Delete(id);
        return "redirect:/organizations";
    }

    @GetMapping("editOrganization")
    public String editOrganization(Integer id, Model model) {
        Organization organization = organizationDao.ReadById(id);
        List<Hero> heroes = heroDao.ReadAll();
        model.addAttribute("organization", organization);
        model.addAttribute("heroes", heroes);
        model.addAttribute("errors", violations);
        return "editOrganization";
    }

    @PostMapping("editOrganization")
    public String performEditOrganization(Organization organization, HttpServletRequest request) {
        String[] heroIds = request.getParameterValues("heroId");
        List<Hero> heroes = new ArrayList<>();
        for (String heroId : heroIds) {
            heroes.add(heroDao.ReadById(Integer.parseInt(heroId)));
        }
        organization.setHeroes(heroes);
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(organization);

        if (violations.isEmpty()) {
             organizationDao.Update(organization);

        }
       
        return "redirect:/organizations";
    }
}
