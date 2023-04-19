package in.dibya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/login")
	public String loginPage() {
		
		return"login";
	}
	
	@GetMapping("/singup")
	public String singUpPage() {
		return"singup";
	}
	
	@GetMapping("/unlock")
	public String unlockPage() {
		
		return "unlock";
	}
	
	@GetMapping("/forgot")
	public String forgotPwdPage() {
		
		return"forgotPwd";
		
	}
}
