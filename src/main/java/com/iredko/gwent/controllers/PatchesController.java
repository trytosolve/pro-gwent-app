package com.iredko.gwent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/patches")
public class PatchesController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getPatches(ModelAndView model) {
        model.setViewName("patchesPage");
        return model;
    }
}
