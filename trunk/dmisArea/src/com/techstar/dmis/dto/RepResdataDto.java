package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 报表数据
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class RepResdataDto  implements Serializable {
    
	public RepResdataDto() {
    }
	
          private byte[] f_data; //数据
	      private int f_datasize; //大小
	      private java.sql.Date f_lastdate; //最后更新日期
	      private String res_id; //资源ID
	      private int version; //数据库版本控制
		 

  	
	
   /**
     * getters and setters
     */
           public void setF_data(byte[] f_data){
        this.f_data=f_data;
    }
	   public byte[] getF_data(){
      return f_data;
    }
           public void setF_datasize(int f_datasize){
        this.f_datasize=f_datasize;
    }
	   public int getF_datasize(){
      return f_datasize;
    }
           public void setF_lastdate(java.sql.Date f_lastdate){
        this.f_lastdate=f_lastdate;
    }
	   public java.sql.Date getF_lastdate(){
      return f_lastdate;
    }
           public void setRes_id(String res_id){
        this.res_id=res_id;
    }
	   public String getRes_id(){
      return res_id;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
      
  

}