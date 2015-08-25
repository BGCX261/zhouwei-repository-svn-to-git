package com.techstar.framework.demo.apply.web.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.upload.FormFile;

import com.techstar.framework.demo.dto.ApplyDto;
import com.techstar.framework.web.form.BaseForm;

public class ApplyForm extends BaseForm {
	private List applyList = new ArrayList();

	private ApplyDto applyDto = new ApplyDto();

	private String ajaxTest = "ajaxTest";
	
	private String actorid = "actorid";
	
	private FormFile attachment;
	
	public ApplyForm() {

	}

	public ApplyDto getApplyDto() {
		return applyDto;
	}

	public void setApplyDto(ApplyDto applyDto) {
		this.applyDto = applyDto;
	}

	public List getApplyList() {
		return applyList;
	}

	public void setApplyList(List applyList) {
		this.applyList = applyList;
	}

	public String getAjaxTest() {
		return ajaxTest;
	}

	public void setAjaxTest(String ajaxTest) {
		this.ajaxTest = ajaxTest;
	}

	public String getActorid() {
		return actorid;
	}

	public void setActorid(String actorid) {
		this.actorid = actorid;
	}

	public FormFile getAttachment() {
		return attachment;
	}

	public void setAttachment(FormFile attachment) {
		this.attachment = attachment;
	}	
	
}
