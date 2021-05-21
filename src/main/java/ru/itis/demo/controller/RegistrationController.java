package ru.itis.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.itis.demo.model.dto.RegistrationDto;
import ru.itis.demo.service.SignUpService;

@Controller
public class RegistrationController {


    @Autowired
    private SignUpService signUpService;

    @GetMapping("/registration")
    public String getRegistrationPage(){
        return "Registraion.jsp";
    }

    public void addUser(@RequestBody RegistrationDto dto){
        if(signUpService.signUp(dto).isPresent()){
            //Action then user registrated
        }else {
            //action then something get wrond
        }
    }
}
