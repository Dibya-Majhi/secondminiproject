package in.dibya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.dibya.binding.LoginForm;
import in.dibya.binding.SignUpForm;
import in.dibya.binding.UnlockForm;
import in.dibya.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	
	//for loading the singup page or mpty page 
	@GetMapping("/singup")
	public String singUpPage(Model model) {
		model.addAttribute("user", new SignUpForm());
		
		return"singup";
	}
	
	//i want to submit the form(to submit the i need one method with postRequest)
	@PostMapping("/singup")
	public String singUpHnadle(@ModelAttribute ("user")SignUpForm form, Model model) {
		boolean status = service.singUp(form);
	 if(status) {
		 model.addAttribute("success", "Account created check your email") ;
		 
	 }else {
		model.addAttribute("error", "choose unique email");
	 }
		return"singup";
	}
	
	
	@GetMapping("/unlock")
	                           // this methos taking the quiry paramter
	public String unlockPage(@RequestParam String email, Model model) {
		
		//taking the email id and setting the email id to binding class object 
		UnlockForm unlockFormObj=new UnlockForm();
		unlockFormObj.setEmail(email);
		
		// i want ot send this email id to ui(taking upside)
		model.addAttribute("unlock", unlockFormObj);
		
		return "unlock";
	}
	
	
	
	
	//when we submit the unlock.html that data come to here(or request will come to herre)
	@PostMapping("/unlock")
	public String unlockUserAccount(@ModelAttribute("unlock") UnlockForm unlock,Model model) {
		
		//System.out.println(unlock);
		
		//new password and conform password are  same or not (correct or not)
		
		if(unlock.getNewPwd().equals(unlock.getConformPwd())) {
			boolean status = service.unLockAccount(unlock);
			
			if(status) {
				model.addAttribute("success", "your account unlock successfuly");
			}else {
				model.addAttribute("errmsg", "Given temporary password id incorrect check your email");
			}
			
		}else {

		//if both are not equal
		model.addAttribute("errmsg", "new psd and confirm pswd should be same");
		}
		
		return "unlock";
	}
	

	@GetMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("loginform", new LoginForm());
		
		return"login";
	}
	
	//to handle the form submition i will write one method
	@PostMapping("/login")
	public String login(@ModelAttribute("loginForm") LoginForm loginform, Model model) {
	
		//check im able to get form data or not
		//System.out.println(loginform);
		String status=service.login(loginform);
		
		if(status.contains("success")) {
			//redirect requst to dashboard display method
			return"redirect:/dashboard";
		}
		model.addAttribute("errormsg", status);
		
		
		return"login";
	}
	
	
	@GetMapping("/forgot")
	public String forgotPwdPage() {
		
		return"forgotPwd";
		
	}
}
