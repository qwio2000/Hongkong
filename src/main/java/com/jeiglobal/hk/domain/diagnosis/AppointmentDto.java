package com.jeiglobal.hk.domain.diagnosis;

import lombok.Data;

public class AppointmentDto {
	@Data
	public static class AppointmentSerch {
		private String rCnt;                     
		private String pageNum;            
		private String memGubun;                
		private String memKey;                
		private String mFstName;               
		private String gradeName;                 
		private String guardianName;              
		private String gPhone;                  
		private String memSubjStr;                
		private String statusName;                  
		private String registFstYMD;                
		private String dropFnlYMD;                
		private String deptName;                    
		private String memAppIdx;     
	}
	
	@Data
	public static class AppointmentSerchJson {
		private String student;                     
		private String guardianName;            
		private String addr;                
		private String city;                
		private String gPhone;               
		private String statusCD;                 
		private String statusName;
		private String memKey;     
	}
	
	
}
