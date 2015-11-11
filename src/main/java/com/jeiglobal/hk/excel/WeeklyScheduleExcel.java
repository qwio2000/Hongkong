package com.jeiglobal.hk.excel;

import java.net.*;
import java.util.*;

import javax.servlet.http.*;

import org.apache.poi.hssf.usermodel.*;
import org.springframework.web.servlet.view.document.*;

import com.jeiglobal.hk.domain.member.MemberDto.MemberWeeklyScheduleInfo;

/**
 * 
 * 클래스명 : WeeklyScheduleExcel.java
 *
 * 작성일 : 2015. 11. 10.
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * 설명
 */
public class WeeklyScheduleExcel extends AbstractExcelView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String subj = model.get("subj").toString();
		String userAgent = request.getHeader("User-Agent");
		String fileName = "weeklySchedule_"+subj+".xls";
		
		if(userAgent.indexOf("MSIE") > 0){
		 fileName = URLEncoder.encode(fileName, "utf-8");
		}else{
		 fileName = new String(fileName.getBytes("utf-8"), "iso-8859-1");
		}
		
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");


		List<String> columnName = new ArrayList<String>();
		columnName.add("Time");
		columnName.add("Sunday");
		columnName.add("Monday");
		columnName.add("Tuesday");
		columnName.add("Wednesday");
		columnName.add("Thursday");
		columnName.add("Friday");
		columnName.add("Saturday");
		
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		HSSFSheet sheet = createFirstSheet(workbook);
		createColumnLabel(sheet, cellStyle, columnName);
		
		List<MemberWeeklyScheduleInfo> dataList = (List<MemberWeeklyScheduleInfo>)model.get("dataList");
		for(int i=0; i <= dataList.size()-1; i++){
		 createPageRow(sheet, dataList.get(i), i, cellStyle);
		}
	}
	/**
	 * 엑셀 시트 생성
	 * @param workbook
	 * @return
	 */
	private HSSFSheet createFirstSheet(HSSFWorkbook workbook) {
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "WeeklySchedule");
		sheet.setColumnWidth(0, 256*20);
		sheet.setColumnWidth(1, 256*13);
		sheet.setColumnWidth(2, 256*13);
		sheet.setColumnWidth(3, 256*13);
		sheet.setColumnWidth(4, 256*13);
		sheet.setColumnWidth(5, 256*13);
		sheet.setColumnWidth(6, 256*13);
		sheet.setColumnWidth(7, 256*13);
		sheet.setDefaultRowHeightInPoints(25);
		return sheet;
	}
	/**
	 * 컬럼 라벨 만들기
	 * @param sheet
	 * @param cellStyle
	 * @param columnName
	 */
	private void createColumnLabel(HSSFSheet sheet, HSSFCellStyle cellStyle, List<String> columnName) {
		HSSFRow firstRow = sheet.createRow(0);
		
		HSSFCell cell = null;
		for (int i = 0; i < columnName.size(); i++) {
			cell = firstRow.createCell(i);
			cell.setCellValue(columnName.get(i));
			cell.setCellStyle(cellStyle);
		}
	}
	/**
	 * 엑셀 한 행 만들기
	 * @param sheet
	 * @param info
	 * @param rowNum
	 * @param cellStyle
	 */
	private void createPageRow(HSSFSheet sheet, MemberWeeklyScheduleInfo info, int rowNum, HSSFCellStyle cellStyle) {
		 HSSFRow row = sheet.createRow(rowNum + 1);
		  
		 HSSFCell cell = row.createCell(0);
		 cell.setCellValue(info.getVisitHoursName());
		 cell.setCellStyle(cellStyle);
		 cell = row.createCell(1);
		 cell.setCellValue(info.getMemWeeklyInfo1()); 
		 cell.setCellStyle(cellStyle);
		 cell = row.createCell(2);
		 cell.setCellValue(info.getMemWeeklyInfo2()); 
		 cell.setCellStyle(cellStyle);
		 cell = row.createCell(3);
		 cell.setCellValue(info.getMemWeeklyInfo3()); 
		 cell.setCellStyle(cellStyle);
		 cell = row.createCell(4);
		 cell.setCellValue(info.getMemWeeklyInfo4()); 
		 cell.setCellStyle(cellStyle);
		 cell = row.createCell(5);
		 cell.setCellValue(info.getMemWeeklyInfo5()); 
		 cell.setCellStyle(cellStyle);
		 cell = row.createCell(6);
		 cell.setCellValue(info.getMemWeeklyInfo6()); 
		 cell.setCellStyle(cellStyle);
		 cell = row.createCell(7);
		 cell.setCellValue(info.getMemWeeklyInfo7()); 
		 cell.setCellStyle(cellStyle);
	}

}
