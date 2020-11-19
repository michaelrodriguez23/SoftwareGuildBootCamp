/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hero.controller;

import com.sg.hero.Dao.heroDaoImpl;
import com.sg.hero.Dao.locationDaoImpl;
import com.sg.hero.Dao.sightingDaoImpl;
import com.sg.hero.Dto.Hero;
import com.sg.hero.Dto.Location;
import com.sg.hero.Dto.Sighting;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author michaelrodriguez
 */
@Controller
public class SightingController {

    @Autowired
    sightingDaoImpl sightingDao;

    @Autowired
    locationDaoImpl locationDao;

    @Autowired
    heroDaoImpl heroDao;

    Set<ConstraintViolation<Sighting>> violations = new HashSet<>();

    @GetMapping("sightings")
    public String displaySightings(Model model) {
        List<Sighting> sightings = sightingDao.ReadAll();
        List<Location> locations = locationDao.ReadAll();
        List<Hero> heroes = heroDao.ReadAll();
        model.addAttribute("errors", violations);
        model.addAttribute("sightings", sightings);
        model.addAttribute("locations", locations);
        model.addAttribute("heroes", heroes);
        return "sightings";
    }

    @PostMapping("addSighting")
    public String addSighting(HttpServletRequest request) {

        String dateAsString = request.getParameter("sightingDate");
        String locationId = request.getParameter("locationId");
        String description = request.getParameter("sightingDescription");
        String heroId = request.getParameter("heroId");

        //DateTimeFormatter dateAsString = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        //    LocalDate localDate = LocalDate.parse(dateAsString);
        Location location = locationDao.ReadById(Integer.parseInt(locationId));
        Hero hero = heroDao.ReadById(Integer.parseInt(heroId));

        Sighting sighting = new Sighting();
        sighting.setDescription(description);
        sighting.setLocation(location);
        sighting.setHero(hero);
        if (dateAsString.isEmpty()) {
            dateAsString = null;

            sighting.setDate(null);
        } else {
            sighting.setDate(LocalDate.parse(dateAsString));
        }
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(sighting);

        if (violations.isEmpty()) {
            sightingDao.Create(sighting);

        }
        return "redirect:/sightings";
    }

    @GetMapping("editSighting")
    public String editSighting(HttpServletRequest request, Model model) {

        int id = Integer.parseInt(request.getParameter("id"));
        Sighting sighting = sightingDao.ReadById(id);
        List<Location> locationList = locationDao.ReadAll();
        List<Hero> heroes = heroDao.ReadAll();
        model.addAttribute("heroes", heroes);
        model.addAttribute("locations", locationList);
        model.addAttribute("sighting", sighting);
        model.addAttribute("errors", violations);

        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(sighting);

         
        return "editSighting";
    }

    @PostMapping("editSighting")
    public String performEditSighting(HttpServletRequest request
    ) {

//        int id = sighting.getSightingId();
        String dateAsString = request.getParameter("sightingDate");
        String heroId = request.getParameter("heroId");
        String locationId = request.getParameter("locationId");
        String sightingId = request.getParameter("sightingId");

        Hero hero = heroDao.ReadById(Integer.parseInt(heroId));
        Location location = locationDao.ReadById(Integer.parseInt(locationId));
        // LocalDate localDate = LocalDate.parse(date);

        Sighting sighting = new Sighting();
        sighting.setSightingId(Integer.parseInt(sightingId));
        if (dateAsString.isEmpty()) {
            sighting.setDate(null);
        } else {
            sighting.setDate(LocalDate.parse(dateAsString));
        }

        sighting.setDescription(request.getParameter("sightingDescription"));
        sighting.setHero(hero);
        sighting.setLocation(location);

        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(sighting);

        if (violations.isEmpty()) {
            sightingDao.Update(sighting);
        }

        return "redirect:/sightings";
    }

    @GetMapping("deleteSighting")
    public String deleteSighting(Integer id
    ) {
        sightingDao.Delete(id);
        return "redirect:/sightings";
    }

}
