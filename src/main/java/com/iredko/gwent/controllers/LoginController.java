package com.iredko.gwent.controllers;

import com.iredko.gwent.data.CreationAccountResult;
import com.iredko.gwent.data.LoginResult;
import com.iredko.gwent.data.SecurityManager;
import com.iredko.gwent.data.UserRepository;
import com.iredko.gwent.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    private SecurityManager securityManager;
    private UserRepository userRepository;

    public LoginController(SecurityManager securityManager, UserRepository userRepository) {
        this.securityManager = securityManager;
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getLogin(ModelAndView model) {
        model.setViewName("loginPage");
        return model;
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public ModelAndView regLog(ModelAndView model,HttpSession httpSession,@RequestParam("login") String login,
                               @RequestParam("pwd") String pass) throws Exception {
        LoginResult loginResult = securityManager.login(userRepository.getUserByLogin(login));
        if (loginResult == LoginResult.LOGIN_OK) {
            httpSession.setAttribute("user", login);
        }
        model.addObject("result", loginResult);
        model.setViewName("resultLoginPage");
        return model;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView method(HttpSession httpSession) {
        httpSession.removeAttribute("user");
        return new ModelAndView("redirect:"+"/");
    }

    @RequestMapping(value = "/createAccount",method = RequestMethod.GET)
    public ModelAndView create(HttpSession httpSession, ModelAndView model) {
        model.setViewName("newAccountPage");
        return model;
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ModelAndView createAction(ModelAndView model,HttpSession httpSession, @RequestParam("userid") String login,
                                     @RequestParam("pwd") String pass,@RequestParam("email") String email) throws Exception {
        CreationAccountResult creationAccountResult = securityManager.createAccount(userRepository.getUserByLogin(login));
        if (creationAccountResult == CreationAccountResult.REGITRATION_OK) {
            httpSession.setAttribute("user", login);
        }
        model.addObject("result", creationAccountResult);
        model.setViewName("registrationResult");
        return model;
    }
}
