package securevaultmultiuser.controller;

import securevaultmultiuser.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("login")
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping
    public String login(String User, String Password){

        if (User.isEmpty() || Password.isEmpty() )
        {
            return "usuário ou senha vazios";
        }

        boolean logou = service.Login(User,Password);

        if(logou){
            return "Tudo certo";
        }

        return "Erro";
    }
}
