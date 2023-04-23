package in.dibya.service;

import in.dibya.binding.LoginForm;
import in.dibya.binding.SignUpForm;
import in.dibya.binding.UnlockForm;

public interface UserService {
	
	public String login(LoginForm form); 
	
	public boolean singUp(SignUpForm form);
	
	public boolean unLockAccount(UnlockForm form);
	
	public String forgotPwd(String email);

}
