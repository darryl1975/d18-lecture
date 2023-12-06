package sg.edu.nus.iss.d18lecture.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {
    
    @GetMapping("/hello")
    public ResponseEntity<?> hello() {
        try {
            return new ResponseEntity<>("Hello!!! Springboot is okay...", HttpStatusCode.valueOf(200));
        } catch (Exception ex) {
            return new ResponseEntity<>("Error running Springboot...", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/hellotest")
    @ResponseBody
    public String hellotest() {
        try {
            return "Hello!!! Spring-boot is okay...";
        } catch (Exception ex) {
            return "Error running Spring-boot...";
        }
    }

    // day 18 - slide 8
    @GetMapping("/healthz")
    public ModelAndView getHealthz() {

        ModelAndView mav = new ModelAndView();
        try {

            mav.setViewName("healthy");
            mav.setStatus(HttpStatusCode.valueOf(200));
        } catch (Exception ex) {
            mav.setViewName("unhealth");
            mav.setStatus(HttpStatusCode.valueOf(500));
        }

        return mav;
    }
}
