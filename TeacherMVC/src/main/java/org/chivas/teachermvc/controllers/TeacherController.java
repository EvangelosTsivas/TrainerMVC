
package org.chivas.teachermvc.controllers;

import java.util.List;
import javax.validation.Valid;
import org.chivas.teachermvc.entities.Teacher;
import org.chivas.teachermvc.services.ITeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



/**
 *
 * @author Vagos
 */


@Controller
@RequestMapping("/")
public class TeacherController {
    
  private String listurl = "list";
  private String editurl = "edit";
  private String deleteurl = "delete";
  private String updateurl = "update";   
    @Autowired
	ITeacher service;
	
	@Autowired
	MessageSource messageSource;
        
        
        
        // index with teachers list
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listAllTeachers(ModelMap view, @RequestParam(required = false) String msg) {
        List<Teacher> teachers  = service.findAll();
        view.addAttribute("teachers", teachers);
        view.addAttribute("editurl", editurl);
        view.addAttribute("deleteurl", deleteurl);
        view.addAttribute("msg", msg);
        return("teacherlist");
    }
        
      // get form for new teacher
    @RequestMapping("/new")
    public String newTeacher(ModelMap view) {
        Teacher teacher = new Teacher();
        view.addAttribute("teacher", teacher);
        view.addAttribute("listurl", listurl);
        return("newteacher");
    }

 // post form for new teacher and check teacher validitiy
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveTeacher(ModelMap view,@Valid Teacher teacher,BindingResult result) {
        
        if (result.hasErrors()) {
			return "newteacher";
		}
        if(service.save(teacher)) {
            view.addAttribute("message", new String("Teacher "+ teacher.getFirstName()+" added!"));
        }
        else {
            view.addAttribute("message", new String("Teacher "+ teacher.getFirstName()+" could not be  added!"));
        }
        view.addAttribute("listurl", listurl);
        return("newteacher");
    }	
        
         // delete for an existing teacher
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTeacher(ModelMap view, @PathVariable int id) {
        if(service.delete(id)) {
            view.addAttribute("msg", new String("Deleted Successfully!"));
        } else {
            view.addAttribute("msg", new String("Could not be Deleted!"));
        }
        return("redirect:/list");
    } 
     
      // show edit / update for an existing teacher
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editTeacher(ModelMap view, @PathVariable int id) {
        Teacher teacher = service.findById(id);
        view.addAttribute("teacher", teacher);
        view.addAttribute("updateurl", updateurl);
        return("editteacher");
    }
    
      // store edit / update for an existing teacher and check validitiy
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateTeacher(ModelMap view,@Valid Teacher teacher,BindingResult result) {
        if (result.hasErrors()) {
			return "editteacher";
		}
        service.update(teacher);
        view.addAttribute("msg", new String("Teacher Updated!"));
        return("redirect:/list");
    }
    
    
}

