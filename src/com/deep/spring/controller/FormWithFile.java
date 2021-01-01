package com.deep.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.deep.spring.dao.CustomerDAO;
import com.deep.spring.entity.Vendor;
import com.deep.spring.entity.VendorFile;
import com.deep.spring.entity.VendorModel;
import com.deep.spring.service.VendorService;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/vendors")
public class FormWithFile {

	@Autowired
	private VendorService vendorService;

	@Autowired
	private CustomerDAO customerDAO;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/ajaxdata", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Map<String, Object> ajaxReq(@RequestBody Map<String, Object> data) {
		String text = (String) data.get("text");
		String name = (String) data.get("name");
		System.out.println(name + ", " + text);
		Map<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("success", true);
		return rmap;
	}

	@PreAuthorize("hasRole('ROLE_USER')")
//	@Secured("ROLE_ADMIN")
	@GetMapping("/showVendor")
	public String showVendorForm(Model theModel, HttpSession session) {
		System.out.println("main controller in vendor page");
		VendorModel vendormodel = new VendorModel();
		theModel.addAttribute("theVendor", vendormodel);
		int noOfcustomers = customerDAO.getCustomers().size();
		System.out.println("noOfcustomers: " + noOfcustomers);
		theModel.addAttribute("totalcusts", Integer.toString(noOfcustomers));
		List<Vendor> allVendors = vendorService.getVendorDetails();
		theModel.addAttribute("allVendors", allVendors);
		Gson gson = new Gson();
		String json = gson.toJson(allVendors);
//		System.out.println("JSON Payload: "+json);
		theModel.addAttribute("dtablejson", json);
		String username = (String) session.getAttribute("username");
		System.out.println("from session: " + username);
		return "vendors";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/submitvendor")
	public String submitVendor(@ModelAttribute("theVendor") VendorModel vendormodel, Model model,
			@RequestParam("file") MultipartFile[] files) {
		System.out.println(vendormodel.getVendorname() + " " + vendormodel.getVendorproduct());
		Vendor vendor = new Vendor(vendormodel.getVendorname(), vendormodel.getVendorproduct());

		for (MultipartFile multipartFile : files) {
			String filename = multipartFile.getOriginalFilename();
			vendor.addVendorFile(new VendorFile(filename));
			try {
				byte[] bytes = multipartFile.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File("E:\\" + filename)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		vendorService.saveVendor(vendor);

		List<Vendor> allVendors = vendorService.getVendorDetails();
		model.addAttribute("allVendors", allVendors);
		Gson gson = new Gson();
		String json = gson.toJson(allVendors);
//		System.out.println(json);
		model.addAttribute("dtablejson", json);
		return "vendors";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/loadmore", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Map<String, Object> loadmore(@RequestBody Map<String, Integer> rangemap) {
		Integer start = (Integer) rangemap.get("value");
		System.out.println("load more start: "+start);
		VendorModel vendormodel = new VendorModel();
		List<Vendor> allVendors = vendorService.getVendorDetails(start);
		Gson gson = new Gson();
		String json = gson.toJson(allVendors);
		Map<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("success", true);
		rmap.put("data", allVendors);
		rmap.put("end", start+5);
		return rmap;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/showAllvendors", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<Vendor> showallVendors(@RequestBody Map<String, Integer> rangemap) {
		System.out.println("Hit all list from ajax");
		Integer start = (Integer) rangemap.get("value");
		System.out.println("start: "+start);
		List<Vendor> allVendors = vendorService.getVendorDetails();
		return allVendors;
	}

}
