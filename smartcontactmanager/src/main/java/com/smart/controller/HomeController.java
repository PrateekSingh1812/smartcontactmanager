package com.smart.controller;

import com.smart.dao.UserRepository;
import com.smart.entities.Contact;
import com.smart.entities.User;
import com.smart.helper.Message;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String home(Model m){
        m.addAttribute("title","Home - Smart Contact Manager");
        return "home";
    }

    @RequestMapping("/about")
    public String about(Model m){
        m.addAttribute("title","About - Smart Contact Manager");
        return "about";
    }

    @RequestMapping("/signup")
    public String signup(Model m){
        m.addAttribute("title","Signup - Smart Contact Manager");
        m.addAttribute("user",new User());
        return "signup";
    }

    @PostMapping("/do-register")
    public String registerUser(@ModelAttribute("user")  @Valid User user, BindingResult bindingResult,
                               @RequestParam(value = "agreement",defaultValue = "false") boolean agreement,
                               Model model,
                               HttpSession session
                               ){

        try {
            if (!agreement){
                System.out.println("You hava not agreed to the terms and condition");
                throw new Exception("You hava not agreed to the terms and condition");
            }
            if(bindingResult.hasErrors()){
                System.out.println(bindingResult);
                model.addAttribute("user",user);
                return "signup";
            }
            user.setRole("ROLE_USER");
            user.setEnabled(true);
            System.out.println("agreement : "+agreement);
            System.out.println("User : "+user);
            User result = this.userRepository.save(user);
            model.addAttribute("user",new User());
            session.setAttribute("message",new Message("Registered Successfully","alert-success"));
            return "signup";
        }catch (Exception e){
            e.printStackTrace();
            session.setAttribute("message",new Message("Something went wrong "+e.getMessage(),"alert-danger"));
            return "signup";
        }

    }



}
