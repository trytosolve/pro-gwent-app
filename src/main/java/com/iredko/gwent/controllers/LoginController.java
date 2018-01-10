package com.iredko.gwent.controllers;

import com.iredko.gwent.data.CreationAccountResult;
import com.iredko.gwent.data.LoginResult;
import com.iredko.gwent.data.RegistrationValidator;
import com.iredko.gwent.data.SecurityManager;
import com.iredko.gwent.models.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/loginPage")
public class LoginController {

    private SecurityManager securityManager;

    public LoginController(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getLoginPage(ModelAndView model) {
        model.setViewName("loginPage");
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(ModelAndView model,HttpSession httpSession,@RequestParam("login") String login,
                               @RequestParam("pwd") String pass) throws Exception {
        LoginResult loginResult = securityManager.login(login,pass);
        if (loginResult.equals(LoginResult.LOGIN_OK)) {
            httpSession.setAttribute("user", login);
        }
        model.addObject("result", loginResult);
        model.setViewName("resultLoginPage");
        return model;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession httpSession) {
        httpSession.removeAttribute("user");
        return new ModelAndView("redirect:"+"/");
    }

    @Autowired
    private RegistrationValidator registrationValidator;

    @RequestMapping(value = "/createAccountPage",method = RequestMethod.GET)
    public ModelAndView registration(ModelAndView model) {
        RegistrationForm registrationForm = new RegistrationForm();
        model.addObject("registrationForm", registrationForm);
        model.setViewName("newAccountPage");
        return model;
    }

    @RequestMapping(value = "/createAccountPage",method = RequestMethod.POST)
    public ModelAndView processRegistration(ModelAndView model,RegistrationForm registrationForm, BindingResult result) {
        registrationValidator.validate(registrationForm, result);
        model.setViewName("newAccountPage");
        if (result.hasErrors()) {
            return model;
        }
        return new ModelAndView("redirect:"+"/");
    }


//    @RequestMapping(value = "/createAccountPage",method = RequestMethod.GET)
//    public ModelAndView getNewAccountPage(ModelAndView model) {
//        model.setViewName("newAccountPage");
//        return model;
//    }

//    @RequestMapping(path = "/createAccount", method = RequestMethod.POST)
//    public ModelAndView createAccount(ModelAndView model,HttpSession httpSession, @RequestParam("userid") String login,
//                                     @RequestParam("pwd") String pass,@RequestParam("email") String email) throws Exception {
//        CreationAccountResult creationAccountResult = securityManager.createAccount(login,email,pass);
//        if (creationAccountResult == CreationAccountResult.REGITRATION_OK) {
//            httpSession.setAttribute("user", login);
//        }
//        model.addObject("result", creationAccountResult);
//        model.setViewName("registrationResult");
//        return model;
//    }
}
