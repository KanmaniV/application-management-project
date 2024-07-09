package com.tcs.management.controller;

import java.util.List;


import com.tcs.management.entity.Application;
import com.tcs.management.repository.ApplicationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ApplicationController {

    @Autowired
    ApplicationRepository repo;

    @RequestMapping("/new")
    public String createNewApplication(Model model){
        Application application = new Application();
        model.addAttribute("application", application);
        return "new_application";
        
    }

    @PostMapping("/save")
    public String saveApplication(@ModelAttribute("application") Application application){
        repo.save(application);
        return "redirect:/getAllApplications";
        
    }

    @GetMapping("/getAllApplications")
    public String getAllApplications(Model model){

        List<Application> applications = repo.findAll();
        model.addAttribute("allApplications", applications);

        return "getAllApplications";
    }

    @RequestMapping("/update/{id}")
    public String EditPage(@PathVariable(name = "id") int id, Model model) {
        Application application = repo.findById(id).get();
        model.addAttribute("application", application);
        return "update_application";
    }
  

    @RequestMapping("/delete/{id}")
    public String deleteapplicaton(@PathVariable(name = "id") int id) {
        repo.deleteById(id);
        return "redirect:/getAllApplications";       
    }
    
}
