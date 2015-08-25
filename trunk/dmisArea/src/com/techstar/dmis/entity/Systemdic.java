package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 绯荤粺瀛楀吀瀹炰綋
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class Systemdic implements Serializable {
    
	public Systemdic() {
    }
    		 private String typeid;//瀛楀吀绫诲瀷
					 private String fatherid;//鐖剁紪鍙�
					 private int sys_isvalid;//鏄惁鏈夋晥瀛楁
					 private int orderno;//鎺掑簭鍙�
					 private String input_code;//杈呭姪杈撳叆鐮�
					 private String classify_code;//鍒嗙被缂栫爜
					 private String name;//名称
					 private String systemdicid;//涓婚敭
					 private int version;//数据库版本控制
				
   /**
     * getters and setters
     */
           public void setTypeid(String typeid){
        this.typeid=typeid;
    }
	   public String getTypeid(){
      return typeid;
    }
           public void setFatherid(String fatherid){
        this.fatherid=fatherid;
    }
	   public String getFatherid(){
      return fatherid;
    }
           public void setSys_isvalid(int sys_isvalid){
        this.sys_isvalid=sys_isvalid;
    }
	   public int getSys_isvalid(){
      return sys_isvalid;
    }
           public void setOrderno(int orderno){
        this.orderno=orderno;
    }
	   public int getOrderno(){
      return orderno;
    }
           public void setInput_code(String input_code){
        this.input_code=input_code;
    }
	   public String getInput_code(){
      return input_code;
    }
           public void setClassify_code(String classify_code){
        this.classify_code=classify_code;
    }
	   public String getClassify_code(){
      return classify_code;
    }
           public void setName(String name){
        this.name=name;
    }
	   public String getName(){
      return name;
    }
           public void setSystemdicid(String systemdicid){
        this.systemdicid=systemdicid;
    }
	   public String getSystemdicid(){
      return systemdicid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
      
  

}