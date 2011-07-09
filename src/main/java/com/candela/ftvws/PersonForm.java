package com.candela.ftvws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@RequestMapping("/personForm.htm")
@SessionAttributes("person")
public class PersonForm {

    @Autowired
    private PersonDao personDao;


    @RequestMapping(method = RequestMethod.GET)
    public String setupForm(@RequestParam("personId") int id, ModelMap model) {
        Person person = this.personDao.getPerson(id);
        model.addAttribute("person", person);
        return "personForm";
    }

    @RequestMapping(method = RequestMethod.POST, value = "person")
    public String processSubmit(@ModelAttribute("person") Person person, BindingResult result, SessionStatus status) {
        this.personDao.savePerson(person);
        status.setComplete();
        return "redirect:personDisplay.htm";
    }
}
