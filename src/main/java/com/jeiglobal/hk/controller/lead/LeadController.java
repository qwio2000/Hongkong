package com.jeiglobal.hk.controller.lead;

import java.util.*;

import javax.servlet.http.*;

import lombok.extern.slf4j.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.jeiglobal.hk.domain.*;
import com.jeiglobal.hk.domain.auth.*;
import com.jeiglobal.hk.domain.lead.*;
import com.jeiglobal.hk.service.*;
import com.jeiglobal.hk.service.lead.*;
import com.jeiglobal.hk.utils.*;

/**
 * 클래스명 : LeadController.java
 *
 * 작성일 : 2015. 11. 18.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * Lead 컨트롤러
 */
@Slf4j
@Controller
public class LeadController {

	@Autowired
	private CommonService commonService;

	@Autowired
	private MessageSourceAccessor msa;

	@Autowired
	private LeadService leadService;
	
	//한 페이지에 출력할 레코드 개수
	@Value("${page.size}")
	private int pageSize;
	
	//한 페이지에 출력할 레코드 개수
	@Value("${page.blockSize}")
	private int blockSize;
	
	@RequestMapping(value = { "/ja/leads" }, method = { RequestMethod.GET, RequestMethod.HEAD })
	public String getLeadsPage(Model model, @ModelAttribute LoginInfo loginInfo) {
		List<String> headerScript = new ArrayList<String>();
		List<CodeDtl> leadStatus = commonService.getCodeDtls("0320", loginInfo.getJisaCD(), 1, "Y");
		headerScript.add("lead");
		log.debug("Getting Leads Page");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("leadStatus", leadStatus);
		return "lead/list";
	}
	
	@RequestMapping(value={"/ja/leads/{pageNum:[0-9]+}"}, method = {RequestMethod.GET, RequestMethod.HEAD}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public Map<String, Object> getLeadResultJson(Model model, @PathVariable int pageNum,
			String contactName, String statusCD, String orderBy, String ord,
			@ModelAttribute LoginInfo loginInfo){
		log.debug("Getting Leads Result : contactName : {}, statusCD : {}, orderBy : {}, ord : {}", contactName, statusCD, orderBy, ord);
		PageUtil pageInfo = new PageUtil(pageNum, leadService.getLeadsCount(contactName, statusCD, orderBy, ord, loginInfo.getJisaCD()), blockSize, pageSize);
		Map<String, Object> map = new HashMap<>();
		if(pageInfo.getTotalRowCnt() > 0){
			List<CenterLeads> leads = leadService.getLeads(contactName, statusCD, orderBy, ord, loginInfo.getJisaCD(), pageInfo.getStartRow(), pageInfo.getEndRow());
			map.put("leads", leads);
		}
		map.put("pageInfo", pageInfo);
		return map;
	}
	
	@RequestMapping(value = { "/ja/leads/new" }, method = { RequestMethod.GET, RequestMethod.HEAD })
	public String getLeadsWritePage(Model model, @ModelAttribute LoginInfo loginInfo) {
		log.debug("Getting Leads Write Page");
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("lead");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("howHears", commonService.getCodeDtls("0321", loginInfo.getJisaCD(), 1, "Y"));
		model.addAttribute("centerStates", commonService.getCenterStates(loginInfo.getJisaCD()));
		return "lead/regist";
	}
	
	@RequestMapping(value={"/ja/leads"}, method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String addLeadJson(Model model,
			@ModelAttribute LoginInfo loginInfo, CenterLeads centerLead, HttpServletRequest request){
		centerLead.setRegID(CommonUtils.getWorkId(request));
		centerLead.setLeadYMD(CommonUtils.getCurrentYMD());
		centerLead.setLastContactYMD(CommonUtils.getCurrentYMD());
		centerLead.setStatusCD("01");
		centerLead.setHowHearMore("");
		centerLead.setJisaCD(loginInfo.getJisaCD());
		leadService.addCenterLead(centerLead);
		return msa.getMessage("lead.insert.success");
	}
	
	@RequestMapping(value = { "/ja/leads/{idx:[0-9]+}" }, method = { RequestMethod.GET, RequestMethod.HEAD })
	public String getLeadPage(Model model, @ModelAttribute LoginInfo loginInfo, @PathVariable int idx) {
		log.debug("Getting Lead Page, idx = {}", idx);
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("lead");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("centerLead", leadService.getCenterLeadByIdx(idx));
		model.addAttribute("leadStatus", commonService.getCodeDtls("0320", loginInfo.getJisaCD(), 1, "Y"));
		return "lead/view";
	}
	
	@RequestMapping(value={"/ja/leads/{eIdx:[0-9]+}"}, method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String setLeadJson(@PathVariable int eIdx, CenterLeads centerLead, HttpServletRequest request){
		log.debug("Setting CenterLead : {}", centerLead);
		centerLead.setUpdID(CommonUtils.getWorkId(request));
		leadService.setCenterLead(centerLead);
		return msa.getMessage("lead.update.success");
	}
	
	@RequestMapping(value={"/ja/leads/notes/{idx:[0-9]+}"}, method = {RequestMethod.GET, RequestMethod.HEAD}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public Map<String, Object> getLeadNotesJson(@PathVariable int idx){
		Map<String, Object> map = new HashMap<>();
		map.put("notes", leadService.getLeadNotesByIdx(idx));
		return map;
	}
	
	@RequestMapping(value={"/ja/leads/notes/{idx:[0-9]+}"}, method = {RequestMethod.POST}, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String addLeadNotesJson(Model model, @PathVariable int idx,
			@ModelAttribute LoginInfo loginInfo, CenterLeadsNote note, HttpServletRequest request){
		note.setClIdx(idx);
		note.setNoteDate(CommonUtils.getCurrentYMD());
		note.setRegID(CommonUtils.getWorkId(request));
		note.setJisaCD(loginInfo.getJisaCD());
		leadService.addCenterLeadNote(note);
		return msa.getMessage("lead.note.insert.success");
	}
	
	@RequestMapping(value = { "/ja/leads/edit/{idx:[0-9]+}" }, method = { RequestMethod.GET, RequestMethod.HEAD })
	public String getLeadEditPage(Model model, @ModelAttribute LoginInfo loginInfo, @PathVariable int idx) {
		log.debug("Getting Lead Edit Page, idx = {}", idx);
		List<String> headerScript = new ArrayList<String>();
		headerScript.add("lead");
		model.addAttribute("headerScript", headerScript);
		model.addAttribute("centerLead", leadService.getCenterLeadByIdx(idx));
		model.addAttribute("leadStatus", commonService.getCodeDtls("0320", loginInfo.getJisaCD(), 1, "Y"));
		model.addAttribute("howHears", commonService.getCodeDtls("0321", loginInfo.getJisaCD(), 1, "Y"));
		model.addAttribute("centerStates", commonService.getCenterStates(loginInfo.getJisaCD()));
		return "lead/edit";
	}
}
