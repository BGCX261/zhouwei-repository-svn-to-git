package com.techstar.dmis.web.hunter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.techstar.framework.service.commonquery.ICommonQueryService;
//please add your business methods start
// to do it
//add your business method end
import com.techstar.framework.service.dto.UserProfile;
import com.techstar.framework.service.security.SecurityContext;

/**
 * 业务字典Hunter类 * @author 
 * @date
 */
public class BusinessDicHunter {
	private ICommonQueryService commonQueryService;

	public BusinessDicHunter() {
	}

	public String getName() {
		return "businessdic";
	}

	public List hunter(Map maps) throws Exception {
		String src = (String) maps.get("src");
		List list = new ArrayList();

		if (StringUtils.isEmpty(src)) {
			return new ArrayList();
		} else {
			src = src.trim();
		}
        /*
		if (src.equalsIgnoreCase("SQDW")) {
			list = this.getSqdw();
		} else if (src.equalsIgnoreCase("SQR")) {
			String dwdm = (String) maps.get("dwdm");
			list = this.getSqr(dwdm);
		} else {
			System.out.println("传入Hunter的src不能解析， src=" + src);
		}*/
		//获取人员信息
		list = getPerson(src);
		//System.out.println(list.toString());
		//System.out.println(list);
		return list;
	}
   //please add your business methods start
   // to do it
   //add your business method end
  
   /**
    * @business hunter list
	 	 ************************
	 * @DdSuspprogramrate
	 * @fdispatchunitname
	 * @Std_scheduleunit
	 **********************
	 	 ************************
	 * @DdfsModechangelist
	 * @fstationid
	 * @Std_station.fid
	 **********************
	 	 ************************
	 * @StdDdaccidentreason
	 * @accidenteqpid
	 * @stddevclassid
	 **********************
	 	 ************************
	 * @DdfsModechangelist
	 * @fstationname
	 * @std_station.Fstationname
	 **********************
	     */
	/*
	private List getSqdw() {
		String sql = "select t.dwdm as code, t.dwmc as name from dmis_apply_dw t";
		return commonQueryService.getListBySql(sql);
	}

	private List getSqr(String dwdm) {
		String sql = "select t.rydm as code, t.rymc as name from dmis_apply_ry t where dwdm='" + dwdm + "'";
		return commonQueryService.getListBySql(sql);
	}*/
	/**
	 * 获取人员信息
	 */
    private List getPerson(String wheres){  
    	int oIndex = wheres.indexOf(".");
    	String entityName = wheres.substring(0,oIndex);    	
    	String colName = wheres.substring(oIndex + 1); 
    	//UserProfile userP = (UserProfile) (request.getSession().getAttribute(SecurityContext.SECURITY_AUTHENTICATION_KEY));
    	String unitid = "12";
    	String deptid = "11";
    	String sql = "select "+"t."+ colName +" from "+entityName+" t where "+" t.unitid='"+unitid+"' and t.deptid='"+deptid+"'";
    	
    	return commonQueryService.getQueryDataByHQL(sql);
    	    	
    }
	public void setCommonQueryService(ICommonQueryService commonQueryService) {
		this.commonQueryService = commonQueryService;
	}
}