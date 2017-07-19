package by.controller;

import by.model.Employee;
import by.service.ServiceEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerMain {
    private ServiceEmployee serviceEmployee;
@Autowired( required = true)
@Qualifier(value = "serviceEmployee")
    public void setServiceEmployee(ServiceEmployee serviceEmployee) {
        this.serviceEmployee = serviceEmployee;
    }

    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public ModelAndView main(Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("list", serviceEmployee.list());
        return new ModelAndView("index");
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Employee employee){
        serviceEmployee.add(employee);
        return "redirect:/index";
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id){
        serviceEmployee.delete(id);
        return "redirect:/index";
    }
    @RequestMapping(value="/findbyid/{id}")
    public ModelAndView findById(@PathVariable("id") int id, Model model){
        model.addAttribute("employee", serviceEmployee.findById(id));
        return new ModelAndView("edit");
    }
    @RequestMapping(value = "/edit")
    public String update(@ModelAttribute("employee") Employee employee){
        serviceEmployee.update(employee);
        return "redirect:/index";
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(ModelMap model,String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }
}
