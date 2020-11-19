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
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
public class SightingController {
    @Autowired
    sightingDaoImpl sightingDao;
    @Autowired
    locationDaoImpl locationDao;
    @Autowired
    heroDaoImpl heroDao;
        @GetMapping("sightings")
    public String displaySightings(Model model) {
        List<Sighting> sightings = sightingDao.ReadAll();
        List<Location> locations = locationDao.ReadAll();
        List<Hero> heroes = heroDao.ReadAll();
        model.addAttribute("sightings", sightings);
        model.addAttribute("locations", locations);
        model.addAttribute("heroes", heroes);
        return "sightings";
    }
    @PostMapping("addSighting")
    public String addSighting(HttpServletRequest request) {
        String date = request.getParameter("sightingDate");
        String locationId = request.getParameter("locationId");
        String description = request.getParameter("sightingDescription");
        String heroId = request.getParameter("heroId");
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
         LocalDate localDate = LocalDate.parse(date);
        Location location = locationDao.ReadById(Integer.parseInt(locationId));
        Hero hero = heroDao.ReadById(Integer.parseInt(heroId));
       Sighting sighting = new Sighting();
        sighting.setDescription(description);
        sighting.setLocation(location);
        sighting.setHero(hero);
        sighting.setDate(localDate);
        sightingDao.Create(sighting);
        return "redirect:/sightings";
    }
}