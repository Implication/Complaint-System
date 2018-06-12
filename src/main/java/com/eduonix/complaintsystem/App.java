package com.eduonix.complaintsystem;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eduonix.complaintsystem.dao.ComplaintDao;
import com.eduonix.complaintsystem.entities.Complaint;

@PropertySource({"classpath:admin-properties.properties"})
@Controller
public class App 
{
	@Autowired
	private Environment env;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@RequestMapping("/fileComplaint")
	public String fileComplaint() {	
		return "fileComplaint";
	}
	
	@RequestMapping("/submitComplaint")
	public String submitComplaint(@RequestParam("complaint") String complaint, @RequestParam("email") String email, @RequestParam("name") String name) {
		ComplaintDao dao = new ComplaintDao(sessionFactory);
		Complaint c = new Complaint(0,complaint,name,email);
		dao.insertComplaint(c);
		System.out.println("Complaint has been submitted");
		return "submitComplaint";
	}

	@RequestMapping(name = "/showComplaints", method = RequestMethod.GET)
	public String showComplaints() {
		return "showEnterPassword";
	}
	
	@RequestMapping(name = "/showComplaints", method = RequestMethod.POST)
	public ModelAndView showComplaintsPost(@RequestParam("pass") String pass, ModelAndView model) {
		if(pass.equals(env.getProperty("admin.password"))) {
			
			ComplaintDao dao = new ComplaintDao(sessionFactory);
			List<Complaint> complaints= dao.getAllComplaints();
			
			model.addObject("complaints", complaints);
			model.setViewName("showComplaints");
			
		}
		else
			model.setViewName("showEnterPassword");
		return model;
	}
}
