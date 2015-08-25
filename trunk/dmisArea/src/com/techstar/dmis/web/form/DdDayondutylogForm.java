package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.DdDayondutylogDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class DdDayondutylogForm extends BaseForm {
	
	private DdDayondutylogDto ddDayondutylogDto = new DdDayondutylogDto();

	
				      private FormFile content;
	   		
	public DdDayondutylogForm() {

	}

	public DdDayondutylogDto getDdDayondutylogDto() {
		return ddDayondutylogDto;
	}

	public void setDdDayondutylogDto(DdDayondutylogDto ddDayondutylogDto) {
		this.ddDayondutylogDto = ddDayondutylogDto;
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
