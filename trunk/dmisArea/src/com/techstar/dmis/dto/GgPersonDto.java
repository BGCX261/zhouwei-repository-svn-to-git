package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 人员
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class GgPersonDto extends DictionaryBaseDto implements Serializable {
    
	public GgPersonDto() {
    }
	
          private String unitname; //单位名称
	      private String unitid; //单位编号
	      private String deptid; //所属部门ID
	      private String deptname; //所属部门
	      private String workid; //工作证号
	      private String name; //姓名
	      private String sex; //性别
	      private java.sql.Date birthday; //出生日期
	      private String dutyname; //岗位名称
	      private int dutylevel; //岗级
	      private String nationality; //民族
	      private String politicalid; //政治面貌
	      private java.sql.Date workdate; //参加工作时间
	      private String degree; //现学历
	      private String title; //职称
	      private String telephone; //联系电话Mobil
	      private String idleader; //是否中心领导
	      private String remark; //备注
	      private String ftelephoneo; //办公室电话
	      private String fmajor; //专业
	      private int version; //数据库版本控制
		 

  	
	
   /**
     * getters and setters
     */
           public void setUnitname(String unitname){
        this.unitname=unitname;
    }
	   public String getUnitname(){
      return unitname;
    }
           public void setUnitid(String unitid){
        this.unitid=unitid;
    }
	   public String getUnitid(){
      return unitid;
    }
           public void setDeptid(String deptid){
        this.deptid=deptid;
    }
	   public String getDeptid(){
      return deptid;
    }
           public void setDeptname(String deptname){
        this.deptname=deptname;
    }
	   public String getDeptname(){
      return deptname;
    }
           public void setWorkid(String workid){
        this.workid=workid;
    }
	   public String getWorkid(){
      return workid;
    }
           public void setName(String name){
        this.name=name;
    }
	   public String getName(){
      return name;
    }
           public void setSex(String sex){
        this.sex=sex;
    }
	   public String getSex(){
      return sex;
    }
           public void setBirthday(java.sql.Date birthday){
        this.birthday=birthday;
    }
	   public java.sql.Date getBirthday(){
      return birthday;
    }
           public void setDutyname(String dutyname){
        this.dutyname=dutyname;
    }
	   public String getDutyname(){
      return dutyname;
    }
           public void setDutylevel(int dutylevel){
        this.dutylevel=dutylevel;
    }
	   public int getDutylevel(){
      return dutylevel;
    }
           public void setNationality(String nationality){
        this.nationality=nationality;
    }
	   public String getNationality(){
      return nationality;
    }
           public void setPoliticalid(String politicalid){
        this.politicalid=politicalid;
    }
	   public String getPoliticalid(){
      return politicalid;
    }
           public void setWorkdate(java.sql.Date workdate){
        this.workdate=workdate;
    }
	   public java.sql.Date getWorkdate(){
      return workdate;
    }
           public void setDegree(String degree){
        this.degree=degree;
    }
	   public String getDegree(){
      return degree;
    }
           public void setTitle(String title){
        this.title=title;
    }
	   public String getTitle(){
      return title;
    }
           public void setTelephone(String telephone){
        this.telephone=telephone;
    }
	   public String getTelephone(){
      return telephone;
    }
           public void setIdleader(String idleader){
        this.idleader=idleader;
    }
	   public String getIdleader(){
      return idleader;
    }
           public void setRemark(String remark){
        this.remark=remark;
    }
	   public String getRemark(){
      return remark;
    }
           public void setFtelephoneo(String ftelephoneo){
        this.ftelephoneo=ftelephoneo;
    }
	   public String getFtelephoneo(){
      return ftelephoneo;
    }
           public void setFmajor(String fmajor){
        this.fmajor=fmajor;
    }
	   public String getFmajor(){
      return fmajor;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
      
  

}