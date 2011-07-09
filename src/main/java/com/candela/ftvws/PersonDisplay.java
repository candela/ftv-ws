package com.candela.ftvws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PersonDisplay {

    @Autowired
    private PersonDao personDao;

    @RequestMapping("/personDisplay.htm")
    public ModelMap defaultHandler() {
        return new ModelMap("personList", this.personDao.getPersons());
    }
}