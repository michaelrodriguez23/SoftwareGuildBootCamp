/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hero.controller;
import com.sg.hero.Dao.heroDaoImpl;
import com.sg.hero.Dao.locationDaoImpl;
import com.sg.hero.Dao.organizationDaoImpl;
import com.sg.hero.Dao.sightingDaoImpl;
import com.sg.hero.Dao.superpowerDaoImpl;
import com.sg.hero.Dto.Location;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
/**
 *
 * @author michaelrodriguez
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.sg.hero.Dao.heroDaoImpl;
import com.sg.hero.Dao.locationDaoImpl;
import com.sg.hero.Dao.organizationDaoImpl;
import com.sg.hero.Dao.sightingDaoImpl;
import com.sg.hero.Dao.superpowerDaoImpl;
import com.sg.hero.Dto.Hero;
import com.sg.hero.Dto.Location;
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
 * @author michaelrodriguez
 */
@Controller
public class LocationController {
    @Autowired
    sightingDaoImpl sightingDao;
    @Autowired
    organizationDaoImpl organizationDao;
    @Autowired
    heroDaoImpl heroDao;
    @Autowired
    locationDaoImpl locationDao;
    @Autowired
    superpowerDaoImpl superpowerDao;
    
    
    Set<ConstraintViolation<Location>> violations = new HashSet<>();
    @GetMapping("locations")
    public String displayLocations(Model model) {
        List<Location> locations = locationDao.ReadAll();
        model.addAttribute("locations", locations);
        model.addAttribute("errors", violations);
        violations = new HashSet<>();
        return "locations";
    }
    @PostMapping("addLocation")
    public String addLocation(String locationDescription, String street, String city,
            String state, String zip, Double lattitude, Double longitude) {
        Location location = new Location();
        location.setLocationDescription(locationDescription);
        location.setStreet(street);
        location.setCity(city);
        location.setState(state);
        location.setZip(zip);
        location.setLattitude(lattitude);
        location.setLongitude(longitude);
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(location);
        if (violations.isEmpty()) {
            locationDao.Create(location);
        }
        return "redirect:/locations";
    }
    @GetMapping("deleteLocation")
    public String deleteLocation(Integer id) {
        locationDao.Delete(id);
        return "redirect:/locations";
    }
    @GetMapping("editLocation")
    public String editLocation(Integer id, Model model) {
        Location location = locationDao.ReadById(id);
        model.addAttribute("location", location);
        model.addAttribute("errors", violations);
        violations = new HashSet<>();
        return "editLocation";
    }
    @PostMapping("editLocation")
    public String performEditLocation(Location location) {
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(location);
        if (violations.isEmpty()) {
            locationDao.Update(location);
        }
        return "redirect:/locations";
    }
}