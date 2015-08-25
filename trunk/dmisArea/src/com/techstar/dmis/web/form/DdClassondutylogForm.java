package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.DdClassondutylogDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class DdClassondutylogForm extends BaseForm {
	
	private DdClassondutylogDto ddClassondutylogDto = new DdClassondutylogDto();

	
				      private FormFile content;
	   		
	public DdClassondutylogForm() {

	}

	public DdClassondutylogDto getDdClassondutylogDto() {
		return ddClassondutylogDto;
	}

	public void setDdClassondutylogDto(DdClassondutylogDto ddClassondutylogDto) {
		this.ddClassondutylogDto = ddClassondutylogDto;
	}

						
	public FormFile getContent() {
		return content;
	}

	public void setContent(FormFile content) {
		this.content = content;
	}
			
	//please add your business methods start
	// to do it
    //add your business method end
}
