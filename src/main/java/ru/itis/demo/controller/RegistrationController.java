package ru.itis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.itis.demo.model.dto.RegistrationDto;
import ru.itis.demo.service.SignUpService;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private SignUpService signUpService;

    private RegistrationDto registrationDto = new RegistrationDto();

    @PostMapping("/registration")
    public String postRegistrationPage(@Valid RegistrationDto registrationDto, ModelMap modelMap){
        modelMap.put("personForm", registrationDto);
        signUpService.signUp(registrationDto);
        return "registration";
    }

    @PostMapping("/registerlord")
    public String postRegistrationLordPage(@Valid RegistrationDto registrationDto, ModelMap modelMap){
        modelMap.put("personForm", registrationDto);
        signUpService.signUpAsLandlord(registrationDto);
        return "registration";
    }

    @GetMapping("/registration")
    public String getRegistrationPage(ModelMap modelMap){
        modelMap.put("personForm", registrationDto);
        return "registration";
    }

    @GetMapping("/registerlord")
    public String getRegistrationLordPage(ModelMap modelMap){
        modelMap.put("personForm", registrationDto);
        return "registration";
    }

}
