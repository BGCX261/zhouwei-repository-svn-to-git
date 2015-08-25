package com.techstar.framework.service.workflow.bus.dto;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public class TaskRoleDto {
	
	long process_id;
	long task_id;
	String task_name;
	List   roles = new ArrayList();
	List   agencys = new ArrayList();
	String task_role = "";
	String agency_role="";
	long    neccesory;
	long   premission_id;
	String[] task_roles= new String[50];
    String[] agency_roles=new String[50];
	
	
	public void setAgencys(List agencys) {
		this.agencys = agencys;
	}
	public List getAgencys() {
		String[] agency_str = getAgency_roles();
		for(int i=0;i<agency_str.length;i++){
			agencys.add(agency_str[i]);
		}
		return agencys;
	}
	public void setAgency(List agencys) {
		this.agencys = agencys;
	}
	

	public long getProcess_id() {
		return process_id;
	}
	public void setProcess_id(long process_id) {
		this.process_id = process_id;
	}

	public String getAgency_role() {
		return agency_role;
	}
	public void setAgency_role(String agency_role) {
		this.agency_role = agency_role;
	}
	public long getNeccesory() {
		return neccesory;
	}
	public void setNeccesory(long neccesory) {
		this.neccesory = neccesory;
	}
	public long getPremission_id() {
		return premission_id;
	}
	public void setPremission_id(long premission_id) {
		this.premission_id = premission_id;
	}
	public String getTask_role() {
		return task_role;
	}
	public void setTask_role(String task_role) {
		this.task_role = task_role;
	}
	public List getRoles() {
		String[] role_str = getTask_roles();
		for(int i=0;i<role_str.length;i++){
			roles.add(role_str[i]);
		}
		return roles;
	}

	public long getTask_id() {
		return task_id;
	}
	public void setTask_id(long task_id) {
		this.task_id = task_id;
	}
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	
	public String[] getAgency_roles() {
		if(StringUtils.isNotEmpty(this.getAgency_role())){
		  agency_roles = StringUtils.split(this.getAgency_role(),";");
		}
		return agency_roles;
	}
	public String[] getTask_roles() {
		if(StringUtils.isNotEmpty(this.getTask_role())){
		task_roles = StringUtils.split(this.getTask_role(),";");
		}
		return task_roles;
	}
	
	public String setTask_role_str(){
		String str ="";
		List task_role_list = this.getRoles();
		for (int i=0;i<task_role_list.size();i++){
			if(i!=task_role_list.size()-1){
			 str =str+String.valueOf(task_role_list.get(i))+";";
			}else{
			 str =str+String.valueOf(task_role_list.get(i));
			}
		}
		return str;
	}
	
	public String setAgency_role_str(){
		String str ="";
		List agency_role_list = this.getAgencys();
		for (int i=0;i<agency_role_list.size();i++){
			if(i!=agency_role_list.size()-1){
			 str =str+String.valueOf(agency_role_list.get(i))+";";
			}else{
			 str =str+String.valueOf(agency_role_list.get(i));
			}
		}
		return str;
	}
	
	
	
}
