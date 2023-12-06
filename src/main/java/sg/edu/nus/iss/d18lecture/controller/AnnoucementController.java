package sg.edu.nus.iss.d18lecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

import sg.edu.nus.iss.d18lecture.model.Announcement;

@Controller
@RequestMapping(path = "/announcements")
public class AnnoucementController {
    
    @GetMapping(path = "/create")
    public String announcementCreateForm(Model model) {
        Announcement announcement = new Announcement();
        model.addAttribute("announcement", announcement);
        return "announcementcreate";
    }

    @PostMapping(path = "/processAnnouncement")
    public String postAnnouncement(@Valid @ModelAttribute("announcement") Announcement announcement, BindingResult result) {

        if (result.hasErrors()) {
            return "announcementcreate";
        }
        
        return "";
    }
    
    
}
