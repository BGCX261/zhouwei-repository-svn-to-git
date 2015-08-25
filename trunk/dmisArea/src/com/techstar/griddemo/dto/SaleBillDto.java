package  com.techstar.griddemo.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 销售总单
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class SaleBillDto  implements Serializable {
    
	public SaleBillDto() {
    }
	
	public String toString(){
	    StringBuffer sb = new StringBuffer();
 sb.append("[ATTR_CNNAEM:开票日期&ATTR_ENNAME:cre_date&ATTR_TYPE:date&ATTR_LENGTH:0&ATTR_VALUE:"+this.getCre_date()+"]");
 sb.append("$%$[ATTR_CNNAEM:custom_id&ATTR_ENNAME:custom_id&ATTR_TYPE:string&ATTR_LENGTH:32&ATTR_VALUE:"+this.getCustom_id()+"]");
 sb.append("$%$[ATTR_CNNAEM:custom_name&ATTR_ENNAME:custom_name&ATTR_TYPE:string&ATTR_LENGTH:40&ATTR_VALUE:"+this.getCustom_name()+"]");
 sb.append("$%$[ATTR_CNNAEM:sale_mode&ATTR_ENNAME:sale_mode&ATTR_TYPE:string&ATTR_LENGTH:10&ATTR_VALUE:"+this.getSale_mode()+"]");
 sb.append("$%$[ATTR_CNNAEM:Tranpriority&ATTR_ENNAME:tranpriority&ATTR_TYPE:string&ATTR_LENGTH:4&ATTR_VALUE:"+this.getTranpriority()+"]");
 sb.append("$%$[ATTR_CNNAEM:Total&ATTR_ENNAME:total&ATTR_TYPE:integer&ATTR_LENGTH:0&ATTR_VALUE:"+this.getTotal()+"]");
 sb.append("$%$[ATTR_CNNAEM:Memo&ATTR_ENNAME:memo&ATTR_TYPE:string&ATTR_LENGTH:200&ATTR_VALUE:"+this.getMemo()+"]");
 sb.append("$%$[ATTR_CNNAEM:Check_begin_date&ATTR_ENNAME:check_begin_date&ATTR_TYPE:date&ATTR_LENGTH:0&ATTR_VALUE:"+this.getCheck_begin_date()+"]");
 sb.append("$%$[ATTR_CNNAEM:结束日期&ATTR_ENNAME:check_end_date&ATTR_TYPE:date&ATTR_LENGTH:0&ATTR_VALUE:"+this.getCheck_end_date()+"]");
 sb.append("$%$[ATTR_CNNAEM:ID&ATTR_ENNAME:id&ATTR_TYPE:string&ATTR_LENGTH:50&ATTR_VALUE:"+this.getId()+"]");
 sb.append("$%$[ATTR_CNNAEM:数据库版本控制&ATTR_ENNAME:version&ATTR_TYPE:integer&ATTR_LENGTH:50&ATTR_VALUE:"+this.getVersion()+"]");
return sb.toString();
	}

	
          private java.sql.Date cre_date;
	      private String custom_id;
	      private String custom_name;
	      private String sale_mode;
	      private String tranpriority;
	      private int total;
	      private String memo;
	      private java.sql.Date check_begin_date;
	      private java.sql.Date check_end_date;
	      private byte[] sale_doc;
	      private String id;
	      private int version;
	      private java.util.Collection saledetails;
	      //private SaleBillAddrDto addr = new SaleBillAddrDto();
		
  	
/*	
   public SaleBillAddrDto getAddr() {
			return addr;
		}

		public void setAddr(SaleBillAddrDto addr) {
			this.addr = addr;
		}*/

/**
     * getters and setters
     */
           public void setCre_date(java.sql.Date cre_date){
        this.cre_date=cre_date;
    }
	   public java.sql.Date getCre_date(){
      return cre_date;
    }
           public void setCustom_id(String custom_id){
        this.custom_id=custom_id;
    }
	   public String getCustom_id(){
      return custom_id;
    }
           public void setCustom_name(String custom_name){
        this.custom_name=custom_name;
    }
	   public String getCustom_name(){
      return custom_name;
    }
           public void setSale_mode(String sale_mode){
        this.sale_mode=sale_mode;
    }
	   public String getSale_mode(){
      return sale_mode;
    }
           public void setTranpriority(String tranpriority){
        this.tranpriority=tranpriority;
    }
	   public String getTranpriority(){
      return tranpriority;
    }
           public void setTotal(int total){
        this.total=total;
    }
	   public int getTotal(){
      return total;
    }
           public void setMemo(String memo){
        this.memo=memo;
    }
	   public String getMemo(){
      return memo;
    }
           public void setCheck_begin_date(java.sql.Date check_begin_date){
        this.check_begin_date=check_begin_date;
    }
	   public java.sql.Date getCheck_begin_date(){
      return check_begin_date;
    }
           public void setCheck_end_date(java.sql.Date check_end_date){
        this.check_end_date=check_end_date;
    }
	   public java.sql.Date getCheck_end_date(){
      return check_end_date;
    }
           public void setSale_doc(byte[] sale_doc){
        this.sale_doc=sale_doc;
    }
	   public byte[] getSale_doc(){
      return sale_doc;
    }
           public void setId(String id){
        this.id=id;
    }
	   public String getId(){
      return id;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setSaledetails(java.util.Collection saledetails){
        this.saledetails=saledetails;
    }
	   public java.util.Collection getSaledetails(){
      return saledetails;
    }
      
  

}