//Source file: C:\\test\\com\\techstar\\framework\\service\\log\\LogServiceImpl.java

package com.techstar.framework.service.log;


import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;

import com.techstar.framework.dao.IBaseJdbcDao;
import com.techstar.framework.exception.BaseException;
import com.techstar.framework.exception.LogServiceException;
import com.techstar.framework.service.dto.LogInfoDTO;
import com.techstar.framework.utils.ConfigurationHelper;
import com.techstar.framework.utils.DateHelper;
import com.techstar.framework.utils.SequenceCreator;


/**
 * 该类为操作日志接口实现类 
 * Sep 11, 2006
 * @author xcf
 */
public class LogServiceImpl implements ILogService {

	/**
	 * 数据库操纵对象
	 */
	private IBaseJdbcDao baseJdbcDao;

	/**
	 * @roseuid 44EAB4ED02FD
	 */
	public LogServiceImpl() {

	}

	/**
	 * 查找数据库中所有的日志信息，返回的集合是每条日志记录格式化为字符串的集合
	 * @return java.util.List
	 * @throws com.techstar.framework.exception.BaseException
	 * @roseuid 44E12D410191
	 */
	private List queryAllLogInfo() throws BaseException {
		return baseJdbcDao.queryForList("queryAllLogInfo");		
	}

	/**
	 * @param logInfoStringList - 
	 * 该参数是从数据库中得到的所有日志信息集合(每条记录为格式化字符串)
	 * @return boolean
	 * @throws com.techstar.framework.exception.BaseException
	 * @roseuid 44E12D3E02AB
	 */
	private boolean writeLogInfoToFile(List logInfoMapList)
			throws BaseException {
		String filename = ConfigurationHelper.getBackupLogFilePath()
				+ getFileName();
		java.io.File f = new java.io.File(filename);
		if (!f.exists())// 如果文件不存，则建立
		{
			try {
				f.createNewFile();
				BufferedWriter bw = new BufferedWriter(new PrintWriter(new FileOutputStream(filename)));
				for (int i = 0; i < logInfoMapList.size(); i++) {
					Map logInfo = (Map) logInfoMapList.get(i);
					String info = getLogInfoStrFromMap(logInfo);
					bw.write(info);// 写内容
					bw.newLine();
				}
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new LogServiceException("pps.logServiceException", e);
			}
		}

		return true;
	}
	
//	得到格式化的日志信息
	private String getLogInfoStrFromMap(Map logInfo) {
		StringBuffer info = new StringBuffer();
		info.append("操作时间:");
		info.append(logInfo.get("operateDate"));
		info.append("|操作人:");
		info.append(logInfo.get("operator"));
		info.append("|操作内容:");
		info.append(logInfo.get("content"));
		return info.toString();
	}

	/**
	 *  该方法主要实现清空数据库中日志信息
	 * @return Object
	 * @throws com.techstar.framework.exception.BaseException
	 * @roseuid 44E131560025
	 */
	private Object clearLogInfo() throws BaseException {
		baseJdbcDao.execute("clearAllLogInfo");
		return Boolean.TRUE;
	}

	/**
	 * 得到备份文件名
	 * @return String
	 * @throws com.techstar.framework.exception.BaseException
	 * @roseuid 44E9106C01CB
	 */
	private String getFileName() throws BaseException {
		StringBuffer filename = new StringBuffer("operatorLog_");
		filename.append(DateHelper.getCurrDateStr());
		filename.append(".txt");
		return filename.toString();
	}

	/**
	 * 保存日志信息至数据库
	 * @param logInfoDto
	 * @return Object
	 * @throws com.techstar.framework.exception.BaseException
	 * @roseuid 44EAB4ED032B
	 */
	public Object saveLogToDb(final LogInfoDTO logInfoDto) throws BaseException {
		LobHandler lobHandler = new DefaultLobHandler();
		Object result = baseJdbcDao.execute("saveLogInfo", new AbstractLobCreatingPreparedStatementCallback(lobHandler) {			  
		       protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException {
		    	   ps.setString(1, new SequenceCreator().getUID()); //利用主键生成器得到序列号
		    	   ps.setString(2, logInfoDto.getOperator());		    	   
		    	   ps.setTimestamp(3, logInfoDto.getOperateDate());
		    	   ps.setString(4, logInfoDto.getContent());		           
		         }
		       });
		return result;
	}

	/**
	 * 按操作人或时间段进行组织查询
	 * @param logInfoDto
	 * @return java.util.List
	 * @throws com.techstar.framework.exception.BaseException
	 * @roseuid 44EAB4ED0389
	 */
	public java.util.List queryLogInfo(LogInfoDTO logInfoDto)
			throws BaseException {		
		if( logInfoDto == null ) return null;
		List logInfos = null;
		if(logInfoDto.getOperator() != null && logInfoDto.getOperateStartDate() != null && logInfoDto.getOperateEndDate() != null ){
			logInfos = baseJdbcDao.queryForList("queryLogInfoForDateAndOperator",new Object[]{logInfoDto.getOperateStartDate() , logInfoDto.getOperateEndDate() , logInfoDto.getOperator()});
		}else if( logInfoDto.getOperator() != null && !"".equals(logInfoDto.getOperator())){
			logInfos = baseJdbcDao.queryForList("queryLogInfoForOperator",new Object[]{logInfoDto.getOperator()});
		}else if( logInfoDto.getOperateStartDate() != null && logInfoDto.getOperateEndDate() != null){
			logInfos = baseJdbcDao.queryForList("queryLogInfoForDate",new Object[]{logInfoDto.getOperateStartDate() , logInfoDto.getOperateEndDate()});
		}
		if( logInfos != null ){			
			for (int i = 0; i < logInfos.size(); i++) {				
				Map logInfo = (Map) logInfos.get(i);
				LogInfoDTO dto = getLogInfoDtoFromMap(logInfo);
				logInfos.set(i, dto);
			}
		}
		return logInfos;
	}

	private LogInfoDTO getLogInfoDtoFromMap(Map logInfo) {
		LogInfoDTO dto = new LogInfoDTO();
		dto.setLogId((String)logInfo.get("id"));
		dto.setOperateDate(java.sql.Timestamp.valueOf(""+logInfo.get("operateDate")));
		dto.setOperator((String)logInfo.get("operator"));
		dto.setContent((String)logInfo.get("content"));
		return dto;
	}

	/**
	 * @return Object
	 * @throws com.techstar.framework.exception.BaseException
	 * @roseuid 44EAB4EE000F
	 */
	public Object backupLogInfo() throws BaseException {
		List logInfos = queryAllLogInfo();  //得到数据库中记录的所有日志信息	
		if( logInfos == null ) return Boolean.FALSE;
		
		System.out.println("得到日志记录共" + logInfos.size() + "条");
		writeLogInfoToFile(logInfos); //将记录备份在文件中
		
		System.out.println("备份至文件");
		clearLogInfo();//清空数据库中的日志信息
		System.out.println("清空数据库日志信息");
		
		return Boolean.TRUE;
	}

	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public static void main(String[] args) {
		//写文件		
		System.out.println("dfdffdfd");
		String str[] = new String[]{"aaaaaadfdfdf中文哈哈哈哈哈哈哈","hello我是第二行"};
		String filename = "E:\\log\\operatorLog_"+DateHelper.getCurrDateStr()+".txt";
		java.io.File f = new java.io.File(filename);
		if(!f.exists())//如果文件不存，则建立
		{
		  try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

		try
		{
//			BufferedOutputStream bos=	new BufferedOutputStream(new FileOutputStream(filename)); 
		 /* PrintWriter pw = new PrintWriter(new FileOutputStream(filename));
		  pw.println(str);//写内容
		  pw.close();*/ 
			BufferedWriter bw = new BufferedWriter(new PrintWriter(new FileOutputStream(filename)));
			bw.write(str[0]);
			bw.newLine();
			bw.write(str[1]);
			bw.close();
		}
		catch(IOException e)
		{
		  e.printStackTrace();
		}


	}
}
