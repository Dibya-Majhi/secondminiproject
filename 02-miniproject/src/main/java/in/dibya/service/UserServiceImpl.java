package in.dibya.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.dibya.binding.LoginForm;
import in.dibya.binding.SignUpForm;
import in.dibya.binding.UnlockForm;
import in.dibya.entity.UserDtlsEntity;
import in.dibya.repo.UserDtlsRepo;
import in.dibya.utils.EmailUtils;
import in.dibya.utils.PwdUtils;


@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserDtlsRepo repo;
	
	
	@Autowired
	private EmailUtils emailUtils;
	
	@Override
	public String login(LoginForm form) {
		
		//i got the login form data in that email id available and passwd is also available
		
		UserDtlsEntity entity=repo.findByEmialAndPwd(form.getEmail(), form.getPwd());
		

		if(entity==null) {
			return"Invalid credential";
		}if(entity.getAccstatus().equals("lock")) {
			return"ypur account is locked";
		}
		return"success";	
	}

	@Override
	public boolean singUp(SignUpForm form) {
		
		
		//call the method and check(i wnat to get the record by using find by methid)
		UserDtlsEntity user = repo.findByEmail(form.getEmail());
		if(user!=null) {
			
			
			return false;
		}
		
		// copy data from binding obj to entity obj
		UserDtlsEntity entity= new UserDtlsEntity();
		BeanUtils.copyProperties(form, entity);
		
		//generate random password and set to object
		String tempPwd = PwdUtils.generateRandomPwd();
		entity.setPwd(tempPwd);
		
		//set account status as Locked
		entity.setAccstatus("Locked");
		
		//insert the record in to the table
		repo.save(entity);
		//send email to user to unlock the account 
		
		String to=form.getEmail();
		String subject ="Unlock your account | Dibya";
		
		StringBuffer body= new StringBuffer("");
		body.append("<h2> Used below temporary password to Unlock your account</h2>");
		
		body.append("temporary password :"+tempPwd);
		body.append("<br/>");
		body.append("<a href=\"http://localhost:8080/unlock?email="+to+"\">click here to unlock your account </a>");
		
		
		emailUtils.sendEmail(to, subject, body.toString());
		return true;
	}

	
	//if both pwd is correct (like new and confirm password is correct then come here) from controller
	@Override
	public boolean unLockAccount(UnlockForm form) {
		
		//i need to check what ever the tempPwd entering the user correct or not(or available in database)
		UserDtlsEntity entity=repo.findByEmail(form.getEmail());//with email id i retrive the record
		//in this entity object what ever the temppwd is comming is matching with entit or not i need to check
		if(entity.getPwd().equals(form.getTempPwd())) {
			entity.setPwd(form.getNewPwd());
			entity.setAccstatus("Unlock");
			repo.save(entity);
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public String forgotPwd(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
