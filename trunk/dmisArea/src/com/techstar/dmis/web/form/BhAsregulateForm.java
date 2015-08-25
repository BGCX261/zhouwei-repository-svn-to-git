package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.BhAsregulateDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class BhAsregulateForm extends BaseForm {
	
	private BhAsregulateDto bhAsregulateDto = new BhAsregulateDto();

	
				      private FormFile asregulateoriginal;
	   	      private FormFile runmodedigram;
	   		
	public BhAsregulateForm() {

	}

	public BhAsregulateDto getBhAsregulateDto() {
		return bhAsregulateDto;
	}

	public void setBhAsregulateDto(BhAsregulateDto bhAsregulateDto) {
		this.bhAsregulateDto = bhAsregulateDto;
	}

						
	public FormFile getAsregulateoriginal() {
		return asregulateoriginal;
	}

	public void setAsregulateoriginal(FormFile asregulateoriginal) {
		this.asregulateoriginal = asregulateoriginal;
	}
				
	public FormFile getRunmodedigram() {
		return runmodedigram;
	}

	public void setRunmodedigram(FormFile runmodedigram) {
		this.runmodedigram = runmodedigram;
	}
			
	//please add your business methods start
	// to do it
    //add your business method end
}
