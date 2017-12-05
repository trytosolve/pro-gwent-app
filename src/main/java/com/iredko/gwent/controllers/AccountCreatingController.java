package com.iredko.gwent.controllers;

import com.iredko.gwent.data.CreateAccount;
import com.iredko.gwent.data.Login;
import com.iredko.gwent.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/createAccount")
public class AccountCreatingController {

    CreateAccount createAccount;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView create(HttpSession httpSession, ModelAndView model) {
        model.setViewName("newAccountPage");
        return model;
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ModelAndView createAction(HttpSession httpSession,
                                  @RequestParam("userid") String name, @RequestParam("pwd") String pass) throws Exception {
        User user = new User(name,pass);
        createAccount = new CreateAccount(user);
        createAccount.newAccount();
        httpSession.setAttribute("USER",user);
        return new ModelAndView("redirect:" + "/");
    }
}
