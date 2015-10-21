package com.jeiglobal.hk.domain.diagnosis;

import lombok.Data;

public class AppointmentDto {
	@Data
	public static class AppointmentSerch {
		private String idx;                     
		private String apmRegistYMD;            
		private String mFstName;                
		private String mLstName;                
		private String mBirthDay;               
		private String gradeCD;                 
		private String schoolName;              
		private String mEmail;                  
		private String eContact;                
		private String ePhone;                  
		private String gFstName;                
		private String gLstName;                
		private String city;                    
		private String stateCD;                 
		private String zip;                     
		private String addr;                    
		private String gEmail;                  
		private String gPhone;                  
		private String gCellPhone;              
		private String preferredYMD;            
		private String preferredTimes;          
		private String preferredNotes;          
		private String apmStatusCD;             
		private String subj;                    
		private String memKey;                  
		private String registYMD;               
		private String freeDigYMD;              
		private String deptCD;                  
		private String jisaCD;                  
		private String regDate;                 
		private String regID;                   
		private String updDate;                 
		private String updID;                   
	}
}
