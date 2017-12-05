package com.iredko.gwent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

//TODO В принципе это вполне ОК и менять не надо,
// просто хотел написать что может быть имеет смысл обьединить login и Logout контроллеры
// потому что занимаются они по сути одним и тем же - текущим юзером. И тут вообще всего 1 метод.
@Controller
public class LogoutController {

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView method(HttpSession httpSession) {
        httpSession.removeAttribute("USER");
        return new ModelAndView("redirect:"+"/");
    }
}
