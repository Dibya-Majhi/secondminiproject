package in.dibya.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.dibya.entity.UserDtlsEntity;



public interface UserDtlsRepo extends JpaRepository<UserDtlsEntity,Integer> {
	
	
	//to get unique email id(find by methid call this one from Userserviceimpl)
	//i need to get the record from the table (like tempPwd)  bothe the time used same 
	public UserDtlsEntity findByEmail(String email);
	
	//i need to check the recordis that gievn email id and password record is availble in the database or not
	public UserDtlsEntity findByEmialAndPwd(String email, String pwd);

}
