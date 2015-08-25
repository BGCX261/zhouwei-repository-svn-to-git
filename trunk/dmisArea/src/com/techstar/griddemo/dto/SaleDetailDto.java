package  com.techstar.griddemo.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 销售明细
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class SaleDetailDto  implements Serializable {
    
	public SaleDetailDto() {
    }
	
	public String toString(){
	    StringBuffer sb = new StringBuffer();
 sb.append("[ATTR_CNNAEM:打印号&ATTR_ENNAME:print_no&ATTR_TYPE:string&ATTR_LENGTH:20&ATTR_VALUE:"+this.getPrint_no()+"]");
 sb.append("$%$[ATTR_CNNAEM:打印时间&ATTR_ENNAME:print_time&ATTR_TYPE:date&ATTR_LENGTH:0&ATTR_VALUE:"+this.getPrint_time()+"]");
 sb.append("$%$[ATTR_CNNAEM:货品数量&ATTR_ENNAME:goodsqty&ATTR_TYPE:integer&ATTR_LENGTH:0&ATTR_VALUE:"+this.getGoodsqty()+"]");
 sb.append("$%$[ATTR_CNNAEM:custom_id&ATTR_ENNAME:custom_id&ATTR_TYPE:string&ATTR_LENGTH:32&ATTR_VALUE:"+this.getCustom_id()+"]");
 sb.append("$%$[ATTR_CNNAEM:客户名称&ATTR_ENNAME:custom_name&ATTR_TYPE:string&ATTR_LENGTH:40&ATTR_VALUE:"+this.getCustom_name()+"]");
 sb.append("$%$[ATTR_CNNAEM:开始时间&ATTR_ENNAME:begin_date&ATTR_TYPE:date&ATTR_LENGTH:0&ATTR_VALUE:"+this.getBegin_date()+"]");
 sb.append("$%$[ATTR_CNNAEM:结束日期&ATTR_ENNAME:end_date&ATTR_TYPE:date&ATTR_LENGTH:0&ATTR_VALUE:"+this.getEnd_date()+"]");
 sb.append("$%$[ATTR_CNNAEM:ID&ATTR_ENNAME:id&ATTR_TYPE:string&ATTR_LENGTH:50&ATTR_VALUE:"+this.getId()+"]");
 sb.append("$%$[ATTR_CNNAEM:数据库版本控制&ATTR_ENNAME:version&ATTR_TYPE:integer&ATTR_LENGTH:50&ATTR_VALUE:"+this.getVersion()+"]");
return sb.toString();
	}

	
          private String print_no;
	      private java.sql.Date print_time;
	      private int goodsqty;
	      private String custom_id;
	      private String custom_name;
	      private java.sql.Date begin_date;
	      private java.sql.Date end_date;
	      private String id;
	      private int version;
	      private com.techstar.griddemo.dto.SaleBillDto saleBillDto =new com.techstar.griddemo.dto.SaleBillDto();
		
  	
	
   /**
     * getters and setters
     */
           public void setPrint_no(String print_no){
        this.print_no=print_no;
    }
	   public String getPrint_no(){
      return print_no;
    }
           public void setPrint_time(java.sql.Date print_time){
        this.print_time=print_time;
    }
	   public java.sql.Date getPrint_time(){
      return print_time;
    }
           public void setGoodsqty(int goodsqty){
        this.goodsqty=goodsqty;
    }
	   public int getGoodsqty(){
      return goodsqty;
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
           public void setBegin_date(java.sql.Date begin_date){
        this.begin_date=begin_date;
    }
	   public java.sql.Date getBegin_date(){
      return begin_date;
    }
           public void setEnd_date(java.sql.Date end_date){
        this.end_date=end_date;
    }
	   public java.sql.Date getEnd_date(){
      return end_date;
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
           public void setSaleBillDto(com.techstar.griddemo.dto.SaleBillDto salebilldto){
        this.saleBillDto=salebilldto;
    }
	   public com.techstar.griddemo.dto.SaleBillDto getSaleBillDto(){
      return saleBillDto;
    }
      
  

}