package com.jeiglobal.hk.service.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeiglobal.hk.repository.inventory.RequestAdditionalWorkbookRepository;
import com.jeiglobal.hk.repository.inventory.WorkbookstatusRepository;

/**
 * 클래스명 : RequestAdditionalWorkbookService.java
 *
 * 작성일 : 2015. 11. 20.
 *
 * 작성자 : 성현범(IT지원팀)
 * 
 * 설명
 */

@Service
public class RequestAdditionalWorkbookService {

	@Autowired
	private RequestAdditionalWorkbookRepository requestAdditionalWorkbookRepository;
}
