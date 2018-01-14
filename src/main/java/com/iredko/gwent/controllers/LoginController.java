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
    public ModelAndView showLoginResult(@ModelAttribute("loginForm") @Valid LoginForm loginForm, BindingResult result, ModelAndView model) {
        if (result.hasErrors()) {
            model.setViewName("loginPage");
            return model;
        }
        return new ModelAndView("redirect:" + "/");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession httpSession) {
        httpSession.removeAttribute("user");
        return new ModelAndView("redirect:" + "/");
    }

    @RequestMapping(value = "/createAccountPage", method = RequestMethod.GET)
    public ModelAndView showRegistrationPage(ModelAndView model, RegistrationForm registrationForm) {
        model.addObject("registrationForm", registrationForm);
        model.setViewName("newAccountPage");
        return model;
    }

    @RequestMapping(value = "/createAccountPage", method = RequestMethod.POST)
    public ModelAndView processRegistration(RegistrationValidator registrationValidator, ModelAndView model,
                                            RegistrationForm registrationForm, BindingResult result) {
        registrationValidator.validate(registrationForm, result);
        if (result.hasErrors()) {
            model.setViewName("newAccountPage");
            return model;
        }
        return new ModelAndView("redirect:" + "/");
    }
}