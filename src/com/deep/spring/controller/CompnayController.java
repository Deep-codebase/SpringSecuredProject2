package com.deep.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deep.spring.entity.CompanyName;
import com.deep.spring.entity.Course;
import com.deep.spring.entity.Instructor;
import com.deep.spring.entity.OperationParameters;
import com.deep.spring.entity.Profile;
import com.deep.spring.entity.Users;
import com.deep.spring.service.ProfileService;

@Controller
@RequestMapping("/company")
public class CompnayController {
	
	@Autowired
	private ProfileService profileService;

	@GetMapping("/showcompanyform")
	public String showCompanyform(Model theModel) {

        // create model attribute to bind form data
        Users users = new Users();

        theModel.addAttribute("users", users);
		return "company-form";
	}
	
	
	
	List<OperationParameters> opParams =null;
    Users viewusers = null;
    
    
    @PostMapping(value = "/proceedCompany")
    public String lazyRowAdd(@ModelAttribute("users") Users user, Model model) {
        viewusers = user;
        System.out.println(user.getName() + ", " + user.getDob() + ", " + user.getPhone());
        opParams = user.getOperationParameterses();
        
        Profile profile1 = new Profile(user.getName(), user.getDob(), user.getPhone());
        
        for( OperationParameters opParam: opParams){
            System.out.println("Parameter: " + opParam.getName());
            profile1.addCompany(new CompanyName(opParam.getName()));
        }
        
		
        
        profileService.saveProfile(profile1);
        model.addAttribute("successmsg", "Record saved successfully");
        return "company-form";
    }
}
