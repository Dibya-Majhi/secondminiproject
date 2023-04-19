package in.dibya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnquiryController {

	@GetMapping("/dashboard")
	public String dashBoardPage() {
		return"dashboard";
	}
	@GetMapping("/Enquiry")
	public String addEnquieryPage() {
		return"add-enquiry";
	}
	@GetMapping("/Enquies")
	public String viewEnquieryPage() {
		return"view-enquiries";  
	}
}
