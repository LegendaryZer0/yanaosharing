package ru.itis.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.itis.demo.model.dto.RegistrationDto;
import ru.itis.demo.service.SignUpService;

@Controller
public class RegistrationController {

    @Autowired
    private SignUpService signUpService;

    @PostMapping("/registration")
    public String postRegistrationPage(RegistrationDto registrationDto){
        signUpService.signUp(registrationDto);
        return "Registraion.jsp";
    }

    @GetMapping("/registration")
    public String getRegistrationPage(){
        return "Registraion.jsp";
    }

}
