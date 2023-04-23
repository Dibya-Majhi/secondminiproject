package in.dibya.service;

import java.util.List;

import in.dibya.binding.DashboardResponse;
import in.dibya.binding.EnquiryForm;
import in.dibya.binding.EnquirySearchCriteria;

public interface EnquiryService {
	
	//to get the drop down display data from()
	public List<String>getCourseName();
	
	//to get the drop down data from(enqdrop down display)
	public List<String>EnqStatus();
	
	
	// get the data from the dashboard
	public DashboardResponse getResponse(Integer userId);
	
	//used to add the enqury(when user submit the data)then we will get the view enquries
	//new record should not be inserted existing record should updated
	public String upsertEnquries(EnquiryForm form);  //upsert used for insert and update
	
	//used to get the enqury(for the view enquries page)
	public List<EnquiryForm> getEnquries(Integer userId, EnquirySearchCriteria criteria);
	
	//once come to enq click on edit that particular enq data we get and  go to editable mode in(add student enq here) 

	public EnquiryForm getEnquiry(Integer enqId);
}
