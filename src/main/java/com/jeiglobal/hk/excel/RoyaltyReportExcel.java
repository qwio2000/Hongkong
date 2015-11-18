/**
 * 
 */
package com.jeiglobal.hk.excel;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.jeiglobal.hk.domain.accounting.RoyaltyOverviewList;

/**
 * 클래스명 : RoyaltyReportExcel.java
 *
 * 작성일 : 2015. 11. 18.
 *
 * 작성자 : 노윤희(IT지원팀)
 * 
 * 설명
 */
public class RoyaltyReportExcel extends AbstractExcelView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String subj = "";//("".equals(model.get("subj").toString()) ? "All" : model.get("subj").toString());
		String selYY = model.get("selYY").toString();
		String selMM = model.get("selMM").toString();
		String userAgent = request.getHeader("User-Agent");
		String fileName = "royaltyReport_"+selYY+"_"+selMM+".xls";
		
		if(userAgent.indexOf("MSIE") > 0){
		 fileName = URLEncoder.encode(fileName, "utf-8");
		}else{
		 fileName = new String(fileName.getBytes("utf-8"), "iso-8859-1");
		}
		
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");

		List<String> columnName = new ArrayList<String>();
		columnName.add("State");
		columnName.add("Center");
		columnName.add("Previous Balance");
		columnName.add("Payment");
		columnName.add("Current Balence");
		columnName.add("Royalty");
		columnName.add("Charge");
		columnName.add("Freight");
		columnName.add("Late Fee");
		columnName.add("Other");
		columnName.add("Total Charge");		
		
		HSSFPalette palette = workbook.getCustomPalette();
		palette.setColorAtIndex((short) 45,
		        (byte) 255,  //RGB red (0-255)
		        (byte) 248,    //RGB green
		        (byte) 236     //RGB blue
		);
		Map<String, Object> styles = getSheetStyles(workbook);
		
		HSSFSheet sheet = createFirstSheet(workbook);
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 10));
		//제목
        Row headerRow = sheet.createRow(0);
        headerRow.setHeightInPoints(35);
        Cell titleCell = headerRow.createCell(0);
        titleCell.setCellValue("RoyaltyReport - "+selYY+"_"+selMM);
        titleCell.setCellStyle((HSSFCellStyle)styles.get("title"));
          
        //컬럼라벨
		createColumnLabel(sheet, (HSSFCellStyle)styles.get("columnName"), columnName);
		
		//데이터 list
		List<RoyaltyOverviewList> dataList = (List<RoyaltyOverviewList>)model.get("royaltyReportList");
		for(int i=0; i <= dataList.size()-1; i++){
			createPageRow(sheet, dataList.get(i), i, (HSSFCellStyle)styles.get("cell"), (HSSFCellStyle)styles.get("centerName"));
		}
		int totalCnt = (dataList.size()>0)? dataList.size() : 0;		
		//데이터 tot
		List<RoyaltyOverviewList> dataTot = (List<RoyaltyOverviewList>)model.get("royaltyReportTot");
		for(int i=0; i <= dataTot.size()-1; i++){
			createPageRowTot(sheet, dataTot.get(i), i, (HSSFCellStyle)styles.get("cell"),totalCnt);
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
		
		style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_LEFT); // 가운데 정렬
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // VERTICAL 가운데 정렬
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		map.put("centerName", style);
		return map;
	}
	/**
	 * 엑셀 시트 생성
	 * @param workbook
	 * @return
	 */
	private HSSFSheet createFirstSheet(HSSFWorkbook workbook) {
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "RoyaltyReport");
		sheet.setColumnWidth(0, 256*20);
		sheet.setColumnWidth(1, 256*50);
		sheet.setColumnWidth(2, 256*13);
		sheet.setColumnWidth(3, 256*13);
		sheet.setColumnWidth(4, 256*13);
		sheet.setColumnWidth(5, 256*13);
		sheet.setColumnWidth(6, 256*13);
		sheet.setColumnWidth(7, 256*13);
		sheet.setColumnWidth(8, 256*13);
		sheet.setColumnWidth(9, 256*13);
		sheet.setColumnWidth(10, 256*13);		
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
	private void createPageRow(HSSFSheet sheet, RoyaltyOverviewList info, int rowNum, HSSFCellStyle cellStyle, HSSFCellStyle centerNameStyle) {
		 HSSFRow row = sheet.createRow(rowNum + 3);
		 row.setHeightInPoints(25);
		 HSSFCell cell = row.createCell(0);
		 cell.setCellValue(info.getStateName());
		 cell.setCellStyle(cellStyle);
		 cell = row.createCell(1);
		 cell.setCellValue(info.getDeptName()); 
		 cell.setCellStyle(centerNameStyle);
		 cell = row.createCell(2);
		 cell.setCellValue(info.getPrevBalance()); 
		 cell.setCellStyle(cellStyle);
		 cell = row.createCell(3);
		 cell.setCellValue(info.getPayment()); 
		 cell.setCellStyle(cellStyle);
		 cell = row.createCell(4);
		 cell.setCellValue(info.getCurrBalance()); 
		 cell.setCellStyle(cellStyle);
		 cell = row.createCell(5);
		 cell.setCellValue(info.getRoyalty()); 
		 cell.setCellStyle(cellStyle);
		 cell = row.createCell(6);
		 cell.setCellValue(info.getChargeItem()); 
		 cell.setCellStyle(cellStyle);
		 cell = row.createCell(7);
		 cell.setCellValue(info.getFreight()); 
		 cell.setCellStyle(cellStyle);
		 cell = row.createCell(8);
		 cell.setCellValue(info.getLateFee()); 
		 cell.setCellStyle(cellStyle);		
		 cell = row.createCell(9);
		 cell.setCellValue(info.getOtherCreditDebit()); 
		 cell.setCellStyle(cellStyle);		
		 cell = row.createCell(10);
		 cell.setCellValue(info.getTotalCharge()); 
		 cell.setCellStyle(cellStyle);		 
	}
	private void createPageRowTot(HSSFSheet sheet, RoyaltyOverviewList info, int rowNum, HSSFCellStyle cellStyle, int listCnt) {
		 HSSFRow row = sheet.createRow(rowNum + 3 + listCnt);
		 row.setHeightInPoints(25);
		 HSSFCell cell = row.createCell(0);
		 sheet.addMergedRegion(new CellRangeAddress(rowNum + 3 + listCnt, rowNum + 3 + listCnt, 0, 1));
		 cell.setCellValue("Total"); 
		 cell.setCellStyle(cellStyle);
		 cell = row.createCell(1);
		 cell.setCellStyle(cellStyle);
		 cell = row.createCell(2);
		 cell.setCellValue(info.getPrevBalance()); 
		 cell.setCellStyle(cellStyle);
		 cell = row.createCell(3);
		 cell.setCellValue(info.getPayment()); 
		 cell.setCellStyle(cellStyle);
		 cell = row.createCell(4);
		 cell.setCellValue(info.getCurrBalance()); 
		 cell.setCellStyle(cellStyle);
		 cell = row.createCell(5);
		 cell.setCellValue(info.getRoyalty()); 
		 cell.setCellStyle(cellStyle);
		 cell = row.createCell(6);
		 cell.setCellValue(info.getChargeItem()); 
		 cell.setCellStyle(cellStyle);
		 cell = row.createCell(7);
		 cell.setCellValue(info.getFreight()); 
		 cell.setCellStyle(cellStyle);
		 cell = row.createCell(8);
		 cell.setCellValue(info.getLateFee()); 
		 cell.setCellStyle(cellStyle);		
		 cell = row.createCell(9);
		 cell.setCellValue(info.getOtherCreditDebit()); 
		 cell.setCellStyle(cellStyle);		
		 cell = row.createCell(10);
		 cell.setCellValue(info.getTotalCharge()); 
		 cell.setCellStyle(cellStyle);		 
	}	

}
