package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Controller
public class HomController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;
    private Matcher matcher;

    @GetMapping("")
    public String home(){
        return "home";
    }
    @PostMapping("/login")
    public String success(@RequestParam String email, Model model){
        boolean check = check(email);
        if (!check){
            model.addAttribute("message", "Email is invalid");
            return "home";
        }
        model.addAttribute("email", email);
        return "success";
    }
    private boolean check(String regex){
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
