package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 保电用户
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class DdEnsuringpsusers implements Serializable {
    
	public DdEnsuringpsusers() {
    }
    		 private String fensuringbillid;//保电源单编号
					 private String fensuringpsuser;//保电用户
					 private String fisimpuser;//是否重要用户
					 private String fimpsuppowstypic;//重要用户供电方式图
					 private String fid;//用户编号
					 private int version;//数据库版本控制
				
   /**
     * getters and setters
     */
           public void setFensuringbillid(String fensuringbillid){
        this.fensuringbillid=fensuringbillid;
    }
	   public String getFensuringbillid(){
      return fensuringbillid;
    }
           public void setFensuringpsuser(String fensuringpsuser){
        this.fensuringpsuser=fensuringpsuser;
    }
	   public String getFensuringpsuser(){
      return fensuringpsuser;
    }
           public void setFisimpuser(String fisimpuser){
        this.fisimpuser=fisimpuser;
    }
	   public String getFisimpuser(){
      return fisimpuser;
    }
           public void setFimpsuppowstypic(String fimpsuppowstypic){
        this.fimpsuppowstypic=fimpsuppowstypic;
    }
	   public String getFimpsuppowstypic(){
      return fimpsuppowstypic;
    }
           public void setFid(String fid){
        this.fid=fid;
    }
	   public String getFid(){
      return fid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
      
  

}