package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.StdModelDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class StdModelForm extends BaseForm {
	
	private StdModelDto stdModelDto = new StdModelDto();

	
		
	public StdModelForm() {

	}

	public StdModelDto getStdModelDto() {
		return stdModelDto;
	}

	public void setStdModelDto(StdModelDto stdModelDto) {
		this.stdModelDto = stdModelDto;
	}

		
	//please add your business methods start
	// to do it
    //add your business method end
}
