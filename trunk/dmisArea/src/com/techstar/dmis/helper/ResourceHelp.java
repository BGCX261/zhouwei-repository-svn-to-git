package com.techstar.dmis.helper;


import java.util.List;

import com.techstar.framework.service.ServiceLocator;
import com.techstar.framework.service.dto.UserProfile;
import com.techstar.framework.service.security.modelout.ResourceOut;

public class ResourceHelp {
	
	
    /**
     * 返回业务资源id字符串
     * @param parentbuid
     * @param desc
     * @return
     */
	public static String getBuids(String parentbuid,String desc){
		  UserProfile userp = ServiceLocator.getUserProfile();
		  List res = userp.getMeun();
		  String buids="";
		  String parentid = getpermId(parentbuid,res);
		  for(int i=0;i<res.size();i++){
			  ResourceOut dto = (ResourceOut) res.get(i);
		      if(parentid.equals(dto.getPERMPARENTID())&&dto.getDESC().equals(desc)){
		    	  buids+=dto.getRESOURCEID()+",";
		      }
		  }
		 if(buids.endsWith(",")){
			 return buids.substring(0,buids.lastIndexOf(","));
		 }else{
			 return buids;
		 }
		 
		
	}
	
	/**
	 * 返回没有权限的业务Ids 
	 * @param parentbuid
	 * @param desc
	 * @param allbuids
	 * @return
	 */
	public static String getNoBuids(String parentbuid,String desc,String[] allbuids){
		 String buids = getBuids(parentbuid,desc);
		 String[] buidsarry = buids.split(",");
		 String noBuids = "";
		 for(int i=0;i<allbuids.length;i++){
			 boolean flag = false;
			 for(int j=0;j<buidsarry.length;j++){
				 if(allbuids[i].equals(buidsarry[j]))
					 flag= true;
			 }
			 if(flag==false)
				 noBuids+=	allbuids[i]+",";
		 }
		 if(noBuids.endsWith(",")){
			 return noBuids.substring(0,noBuids.lastIndexOf(","));
		 }else{
			 return noBuids;
		 }
		
	}
	
	/**
	 * 截取XXXX*code 后边的code 返回字符串
	 * @return
	 */
	public static String getkeycode(String souce ,String cutString){
		String codes = "";
		if(souce.equals(""))
			 return "";
		String[]  sourcearray = souce.split(",");
		for(int i=0;i<sourcearray.length;i++){
			codes+=sourcearray[i].split("\\*")[1]+",";
			
		}
		 if(codes.endsWith(",")){
			 return codes.substring(0,codes.lastIndexOf(","));
		 }else{
			 return codes;
		 }

	}
	 /**
	    * 通过业务Id 取到他的权限资源Id
	    * @param resourceId
	    * @return
	    */
	  private static String getpermId(String resourceId,List ress){
		   
		   for(int i=0;i<ress.size();i++){
				ResourceOut dto = (ResourceOut)ress.get(i);
				if(resourceId.equals(dto.getRESOURCEID()))
					return  dto.getPERMID();
			}
		  return "";
	   }
	 
	 
	/**
	 * 查询有无该业务权限的
	 * @param resourceId
	 * @return
	 */
	public static  boolean  isHaveRes(String resourceId){
		UserProfile userp = ServiceLocator.getUserProfile();
		List res = userp.getMeun();
		  try{
			  for(int i=0;i<res.size();i++){
				  ResourceOut dto = (ResourceOut) res.get(i);
			      if(dto.getRESOURCEID().equals(resourceId)){
			    	  return true;
			      }
			  }
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		return false;
	}
}