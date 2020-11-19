/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hero.controller;

import com.sg.hero.Dao.heroDaoImpl;
import com.sg.hero.Dao.sightingDaoImpl;
import com.sg.hero.Dao.superpowerDaoImpl;
import com.sg.hero.Dto.Sighting;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author alanc
 */
@Controller
public class HomeController {

    @Autowired
    heroDaoImpl heroDao;
    @Autowired
    superpowerDaoImpl superpowerDao;
    @Autowired
    sightingDaoImpl sightingDao;

    @GetMapping("/")
    public String displaySightings(Model model) {

        List<Sighting> sightings = sightingDao.ReadAll();
        model.addAttribute("sightings", sightings);

        return "index";
    }

    @GetMapping("/index")
    public String displayIndex(Model model) {

        List<Sighting> sightings = sightingDao.ReadAll();
        model.addAttribute("sightings", sightings);

        model.addAttribute("index");

        return "index";

    }
}
