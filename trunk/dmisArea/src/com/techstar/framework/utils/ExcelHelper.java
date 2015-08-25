package com.techstar.framework.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * 导出数据到excel文件
 * @author sbt 2007-1-2 
 *
 */
public class ExcelHelper {	
	/**
	 * 在服务端生成Excel文件
	 * @param sourcedata
	 * @param sheetName
	 * @param fileName
	 * @param path
	 * @param otherParams
	 */
	public void createExcel(List sourcedata, String sheetName,
			String fileName, String path, String otherParams) {
		String xmlData = "";
		long rownum = 0;
		int colnum = 0;
		String xml = "";
		String filterrow = "";
		String rows = ""; //总行数,客户端分页时使用
		int gridType = 0; //列表类型
		int listKind = 0; //列表性质
		int isOperater = 0;//是否有操作列
		int isTotalRow = 0;//是否有统计行
		String tcolname = "";//统计列的列名
		int isStatusCol = 0; //是否有行状态列
		String colVal;
		String tmp1[] = null;
		String tmp2[] = null;
		String tmp3[] = null;
		String tmp4[] = null;

		String[] colName = null; //列名
		int[] isToalcol = null; //对应的列是否进行合计
		double[] colTotal = null; //对应的列的合计值

		List outXml = new ArrayList();

		long srdrows = sourcedata.size();
		System.out.println("导出数据到excel文件时查询的记录条数:" + (srdrows - 1));
		if (srdrows < 2) {
			return;
		}
		try {
			/*分析客户端提交的综合参数信息 
			 *如:gridType^3@@@listKind^101@@@isOperater^1@@@isTotalRow^1@@@goodsid^0,,goodsname^0,goodstype^0,goodsunit^0,,prodarea^0,,sutotal^1,,lastsudate^0
			 */
			if (otherParams != null) {
				tmp1 = otherParams.split("@@@");
				for (int m = 0; m < tmp1.length; m++) {
					tmp2 = tmp1[m].split("\\^");
					if (m < (tmp1.length - 1)) {
						if (tmp2[0].equalsIgnoreCase("gridType")) {
							if (tmp2[1] == null || tmp2[1] == "") {
								gridType = 0;
								System.out.println("不能没有列表类型!");
								return;
							} else {
								gridType = Integer.valueOf(tmp2[1]).intValue();
							}

						} else if (tmp2[0].equalsIgnoreCase("listKind")) {
							if (tmp2[1] == null || tmp2[1] == "") {
								listKind = 0;
								System.out.println("不能没有列表性质!");
								return;
							} else {
								listKind = Integer.valueOf(tmp2[1]).intValue();
							}

						} else if (tmp2[0].equalsIgnoreCase("isOperater")) {
							if (tmp2[1] == null || tmp2[1] == "") {
								isOperater = 0;
							} else {
								isOperater = Integer.valueOf(tmp2[1])
										.intValue();
							}

						} else if (tmp2[0].equalsIgnoreCase("isTotalRow")) {
							if (tmp2[1] == null || tmp2[1] == "") {
								isTotalRow = 0;
							} else {
								isTotalRow = Integer.valueOf(tmp2[1])
										.intValue();
							}

						} else if (tmp2[0].equalsIgnoreCase("isStatusCol")) {
							if (tmp2[1] == null || tmp2[1] == "") {
								isStatusCol = 0;
							} else {
								isStatusCol = Integer.valueOf(tmp2[1])
										.intValue();
							}
						}
					} else {
						tmp3 = tmp1[m].split(",");
						//初始化数组
						colName = new String[tmp3.length];
						isToalcol = new int[tmp3.length];
						colTotal = new double[tmp3.length];
						for (int n = 0; n < tmp3.length; n++) {
							tmp4 = tmp3[n].split("\\^");
							colName[n] = tmp4[0];
							if (tmp4[1] == null) {
								System.out.println("判断列是否进行合计时出错了!");
								return;
							}
							isToalcol[n] = Integer.valueOf(tmp4[1]).intValue();
						}
					}

				}
			}
			tmp4 = null;
			//创建新的Excel 工作簿
			HSSFWorkbook workbook = new HSSFWorkbook();
			//创建工作簿字体
			HSSFFont font = workbook.createFont();
			//设置字体颜色为 ,粗体
			font.setColor(HSSFFont.COLOR_NORMAL);
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			//新建指定名称的工作表
			HSSFSheet sheet = workbook.createSheet();
			//设置工作表的名称,字符集
			workbook.setSheetName(0, sheetName, HSSFWorkbook.ENCODING_UTF_16);
            //创建单元格格式
			HSSFCellStyle cellstyle = workbook.createCellStyle();
			//定义全部单元格字体样式
			cellstyle.setFont(font);
			for (int i = 0; i < sourcedata.size(); i++) {
				if (i == sourcedata.size() - 1) {
					//总数据行数,不参与数据的导出			
					Map map = (Map) sourcedata.get(i);
					Set keys = map.keySet();
					for (Iterator iter = keys.iterator(); iter.hasNext();) {
						String key = (String) iter.next();
						rows = map.get(key).toString();
					}
					continue;
				}
				Map map = (LinkedHashMap) sourcedata.get(i);
				Set keys = map.keySet();
				//记录行号
				rownum++;
				colnum = 0;
				//在索引i的位置创建行
				HSSFRow row = sheet.createRow((short) i);

				//增加各列的列值				
				for (Iterator iter = keys.iterator(); iter.hasNext();) {
					String key = (String) iter.next();
					tmp4 = key.split("\\.");
					tcolname = tmp4[1];
					//进行指定列的列值的合计
					if (isTotalRow == 1) {
						for (int w = 0; w < colName.length; w++) {
							if (tcolname.equalsIgnoreCase(colName[w])
									&& isToalcol[w] == 1) {
								colTotal[w] = Double.valueOf(
										map.get(key).toString()).doubleValue()
										+ colTotal[w];
							}
						}
					}
                    //列值
					colVal = (String) map.get(key).toString();
					//去掉左右的空格
					colVal = colVal.trim();
					//替换回车
					colVal = colVal.replaceAll("[\\n\\r]*", "");					
					//在索引0的位置创建单元格
					HSSFCell cell = row.createCell((short) colnum);
					/*
                    //创建单元格格式
					HSSFCellStyle cellstyle = workbook.createCellStyle();
					//定义全部单元格字体样式
					cellstyle.setFont(font);
					*/
					//应用单元格格式
					cell.setCellStyle(cellstyle);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setEncoding(HSSFCell.ENCODING_UTF_16);
					//第一个单元格中的值
					cell.setCellValue(colVal);
                    
					//记录列数
					colnum++;
				}
				
				
			}
			//将Excel文件存盘
			FileOutputStream fileOut = new FileOutputStream(path + fileName);
			workbook.write(fileOut);
			fileOut.flush();
            //导出结束,关闭输出流
			fileOut.close();

		} catch (Exception ex) {
			System.out.println("系统生成EXCEL发生异常" + ex.getMessage());
			ex.printStackTrace();
		}

	}
	/**
	 * 生成Excel所需的字符串，传递到客户端
	 * @param sourcedata
	 * @param sheetName
	 * @param fileName
	 * @param path
	 * @param otherParams
	 */
	public String genExcelStr(List sourcedata,String otherParams) {
		String excelData = "";
		long rownum = 0;
		int colnum = 0;
		String cellData = "";
		String filterrow = "";
		String rows = ""; //总行数,客户端分页时使用
		int gridType = 0; //列表类型
		int listKind = 0; //列表性质
		int isOperater = 0;//是否有操作列
		int isTotalRow = 0;//是否有统计行
		String tcolname = "";//统计列的列名

		String colVal = "";
		String tmp;
		String tmp1[] = null;
		String tmp2[] = null;
		String tmp3[] = null;
		String tmp4[] = null;

		String[] colName = null; //列名
		int[] isToalcol = null; //对应的列是否进行合计
		double[] colTotal = null; //对应的列的合计值

	

		long srdrows = sourcedata.size();
		System.out.println("导出数据到excel文件时查询的记录条数:" + (srdrows - 1));
		if (srdrows < 2) {
			return "";
		}
		try {
			/*分析客户端提交的综合参数信息 
			 *如:gridType^3@@@listKind^101@@@isOperater^1@@@isTotalRow^1@@@goodsid^0,,goodsname^0,goodstype^0,goodsunit^0,,prodarea^0,,sutotal^1,,lastsudate^0
			 */
			if (otherParams != null) {
				tmp1 = otherParams.split("@@@");
				for (int m = 0; m < tmp1.length; m++) {
					tmp2 = tmp1[m].split("\\^");
					if (m < (tmp1.length - 1)) {
						if (tmp2[0].equalsIgnoreCase("gridType")) {
							if (tmp2[1] == null || tmp2[1] == "") {
								gridType = 0;
								System.out.println("不能没有列表类型!");
								return "";
							} else {
								gridType = Integer.valueOf(tmp2[1]).intValue();
							}

						} else if (tmp2[0].equalsIgnoreCase("listKind")) {
							if (tmp2[1] == null || tmp2[1] == "") {
								listKind = 0;
								System.out.println("不能没有列表性质!");
								return "";
							} else {
								listKind = Integer.valueOf(tmp2[1]).intValue();
							}

						} else if (tmp2[0].equalsIgnoreCase("isOperater")) {
							if (tmp2[1] == null || tmp2[1] == "") {
								isOperater = 0;
							} else {
								isOperater = Integer.valueOf(tmp2[1])
										.intValue();
							}

						} else if (tmp2[0].equalsIgnoreCase("isTotalRow")) {
							if (tmp2[1] == null || tmp2[1] == "") {
								isTotalRow = 0;
							} else {
								isTotalRow = Integer.valueOf(tmp2[1])
										.intValue();
							}

						} 
					} else {
						tmp3 = tmp1[m].split(",");
						//初始化数组
						colName = new String[tmp3.length];
						isToalcol = new int[tmp3.length];
						colTotal = new double[tmp3.length];
						for (int n = 0; n < tmp3.length; n++) {
							tmp4 = tmp3[n].split("\\^");
							colName[n] = tmp4[0];
							if (tmp4[1] == null) {
								System.out.println("判断列是否进行合计时出错了!");
								return "";
							}
							isToalcol[n] = Integer.valueOf(tmp4[1]).intValue();
						}
					}

				}
			}
			tmp4 = null;
			
			for (int i = 0; i < sourcedata.size(); i++) {
				if (i == sourcedata.size() - 1) {
					//总数据行数,不参与数据的导出			
					Map map = (Map) sourcedata.get(i);
					Set keys = map.keySet();
					for (Iterator iter = keys.iterator(); iter.hasNext();) {
						String key = (String) iter.next();
						rows = map.get(key).toString();
					}
					continue;
				}
				Map map = (LinkedHashMap) sourcedata.get(i);
				Set keys = map.keySet();
				//记录行号
				rownum++;
				//初始化变量
				colnum = 0;
				
				//增加各列的列值				
				for (Iterator iter = keys.iterator(); iter.hasNext();) {
					String key = (String) iter.next();
					tmp4 = key.split("\\.");
					tcolname = tmp4[1];
					//进行指定列的列值的合计
					if (isTotalRow == 1) {
						for (int w = 0; w < colName.length; w++) {
							if (tcolname.equalsIgnoreCase(colName[w]) && isToalcol[w] == 1) {
								colTotal[w] = Double.valueOf(
										map.get(key).toString()).doubleValue()
										+ colTotal[w];
							}
						}
					}
                    //列值
					colVal = (String) map.get(key).toString();
					//去掉左右的空格
					colVal = colVal.trim();
					//替换回车
					colVal = colVal.replaceAll("[\\n\\r]*", "");
					//各列之间使用@@@隔开
					if (cellData == "" || cellData == null)  {
						cellData += ""+colVal;
					} else {
						cellData += "@@@"+colVal;
					}     
					//记录列数
					colnum++;
				}
				//各行之间使用###隔开
				if (excelData == "" || excelData == null)  {
					excelData += ""+cellData;
				} else {
					excelData += "###"+cellData;
				}  
				//初始化变量
				cellData = "";
				
			}			
            //生成统计行的数据
			if (isTotalRow == 1) {
                //将double转换成string
				DecimalFormat srcformat=new DecimalFormat("###,###.0000");		
				for (int w = 0; w < colName.length; w++) {							
                    //各列之间使用@@@隔开
					if ( java.lang.Math.abs(colTotal[w]) > 0){
						if (cellData == "" || cellData == null)  {
							cellData += ""+srcformat.format(colTotal[w]);
						} else {
							cellData += "@@@"+srcformat.format(colTotal[w]);
						}
				   } else {
					   if (cellData == "" || cellData == null)  {
							cellData += "";
						} else {
							cellData += "@@@";
						}
				   }
					
				}
				excelData += "###"+cellData;
			}
		} catch (Exception ex) {
			System.out.println("系统生成EXCEL发生异常" + ex.getMessage());
			ex.printStackTrace();
		}
		return excelData;
    }
}
