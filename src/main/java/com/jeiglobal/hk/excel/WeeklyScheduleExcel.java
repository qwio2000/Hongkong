package com.jeiglobal.hk.excel;

import java.net.*;
import java.util.*;

import javax.servlet.http.*;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
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
		
		HSSFPalette palette = workbook.getCustomPalette();
		palette.setColorAtIndex((short) 45,
		        (byte) 255,  //RGB red (0-255)
		        (byte) 248,    //RGB green
		        (byte) 236     //RGB blue
		);
		Map<String, Object> styles = getSheetStyles(workbook);
		
		HSSFSheet sheet = createFirstSheet(workbook);
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));
		//제목
        Row headerRow = sheet.createRow(0);
        headerRow.setHeightInPoints(35);
        Cell titleCell = headerRow.createCell(0);
        titleCell.setCellValue("WeeklySchedule - "+subj);
        titleCell.setCellStyle((HSSFCellStyle)styles.get("title"));
          
        //컬럼라벨
		createColumnLabel(sheet, (HSSFCellStyle)styles.get("columnName"), columnName);
		
		//데이터
		List<MemberWeeklyScheduleInfo> dataList = (List<MemberWeeklyScheduleInfo>)model.get("dataList");
		for(int i=0; i <= dataList.size()-1; i++){
		 createPageRow(sheet, dataList.get(i), i, (HSSFCellStyle)styles.get("cell"));
		}
	}
	/**
	 * Style
	 * @return Map<String,Object>
	 */
	private Map<String, Object> getSheetStyles(HSSFWorkbook workbook){ 
		Map<String, Object> map = new HashMap<>();
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor((short)45);// 배경색
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); //배경색 패턴
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); //가운데 정렬
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// VERTICAL 가운데 정렬
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		map.put("columnName", style);
		
		style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 가운데 정렬
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // VERTICAL 가운데 정렬
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		map.put("cell", style);
		
		style = workbook.createCellStyle();
		Font titleFont = workbook.createFont();
		titleFont.setFontHeightInPoints((short)20);
		titleFont.setColor(IndexedColors.BLACK.getIndex());
		style.setFont(titleFont);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 가운데 정렬
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // VERTICAL 가운데 정렬
		map.put("title", style);
		return map;
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
		HSSFRow firstRow = sheet.createRow(1);
		firstRow.setHeightInPoints(25);
		HSSFCell cell = null;
		for (int i = 0; i < columnName.size(); i++) {
			cell = firstRow.createCell(i);
			cell.setCellValue("");
		}
		HSSFRow secondRow = sheet.createRow(2);
		secondRow.setHeightInPoints(25);
		for (int i = 0; i < columnName.size(); i++) {
			cell = secondRow.createCell(i);
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
		 HSSFRow row = sheet.createRow(rowNum + 3);
		 row.setHeightInPoints(25);
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
