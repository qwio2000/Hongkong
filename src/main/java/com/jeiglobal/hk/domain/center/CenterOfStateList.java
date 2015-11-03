/**
 * 
 */
package com.jeiglobal.hk.domain.center;

import lombok.Getter;

/**
 * 클래스명 : CenterOfStateList.java
 *
 * 작성일 : 2015. 10. 29.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명 : 도시/주에 속한 센터 리스트
 * 			입회비 면제 기간 등록/팝업메세지 등록에서 사용
 */
@Getter
public class CenterOfStateList {
	private String jisaCD;
	private String deptCD;
	private String deptName;
	private String compareDeptCD;
		
}
