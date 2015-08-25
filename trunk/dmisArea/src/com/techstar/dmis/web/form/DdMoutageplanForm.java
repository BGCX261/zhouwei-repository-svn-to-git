package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.DdMoutageplanDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class DdMoutageplanForm extends BaseForm {
	
	private DdMoutageplanDto ddMoutageplanDto = new DdMoutageplanDto();

	
				      private FormFile feqpcontent;
	   		
	public DdMoutageplanForm() {

	}

	public DdMoutageplanDto getDdMoutageplanDto() {
		return ddMoutageplanDto;
	}

	public void setDdMoutageplanDto(DdMoutageplanDto ddMoutageplanDto) {
		this.ddMoutageplanDto = ddMoutageplanDto;
	}

						
	public FormFile getFeqpcontent() {
		return feqpcontent;
	}

	public void setFeqpcontent(FormFile feqpcontent) {
		this.feqpcontent = feqpcontent;
	}
			
	//please add your business methods start
	// to do it
    //add your business method end
}
