package com.iredko.gwent.controllers;

import com.iredko.gwent.data.RegistrationValidator;
import com.iredko.gwent.data.SecurityManager;
import com.iredko.gwent.models.LoginForm;
import com.iredko.gwent.models.RegistrationForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/loginPage")
public class LoginController {

    private SecurityManager securityManager;

    public LoginController(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showLoginPage(ModelAndView model, LoginForm loginForm) {
        model.addObject("loginForm", loginForm);
        model.setViewName("loginPage");
        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView showLoginResult(@ModelAttribute("loginForm") @Valid LoginForm loginForm, BindingResult result,
                                        ModelAndView model,HttpSession session) {
        if (result.hasErrors()) {
            model.setViewName("loginPage");
            return model;
        }
        if (!result.hasErrors()) {
            if(!securityManager.userExists(loginForm.getUserLogin())) {
                result.rejectValue("userLogin", "userLogin.exists", "User does not exist!");
                model.setViewName("loginPage");
                return model;
            }
            if (!securityManager.passwordIsCorrect(loginForm.getUserLogin(),loginForm.getUserPassword())) {
                result.rejectValue("userPassword", "userPassword.check", "Wrong password!");
                model.setViewName("loginPage");
                return model;
            }
            session.setAttribute("user",securityManager.findUser(loginForm.getUserLogin()));
            return new ModelAndView("redirect:" + "/");
        }
        return new ModelAndView("redirect:" + "/");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession httpSession) {
        httpSession.removeAttribute("user");
        return new ModelAndView("redirect:" + "/");
    }

    @RequestMapping(value = "/registrationPage", method = RequestMethod.GET)
    public ModelAndView showRegistrationPage(ModelAndView model, RegistrationForm registrationForm) {
        model.addObject("registrationForm", registrationForm);
        model.setViewName("registrationPage");
        return model;
    }

    @RequestMapping(value = "/registrationPage", method = RequestMethod.POST)
    public ModelAndView showRegistrationResult(RegistrationValidator registrationValidator, ModelAndView model,
                                            RegistrationForm registrationForm, BindingResult result,HttpSession session) {
        registrationValidator.validate(registrationForm, result);
        if (result.hasErrors()) {
            model.setViewName("registrationPage");
            return model;
        }
        if (!result.hasErrors()) {
            if(securityManager.userExists(registrationForm.getUserLogin())) {
                result.rejectValue("userLogin", "userLogin.exists", "Login already in use!");
                model.setViewName("registrationPage");
                return model;
            }
            securityManager.saveUser(registrationForm.getUserLogin(),registrationForm.getUserPassword()
                    ,registrationForm.getUserEmail());
            session.setAttribute("user",securityManager.findUser(registrationForm.getUserLogin()));
            return new ModelAndView("redirect:" + "/");
        }
        return new ModelAndView("redirect:" + "/");
    }
}