package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.DdCutofftitleDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class DdCutofftitleForm extends BaseForm {
	
	private DdCutofftitleDto ddCutofftitleDto = new DdCutofftitleDto();

	
		
	public DdCutofftitleForm() {

	}

	public DdCutofftitleDto getDdCutofftitleDto() {
		return ddCutofftitleDto;
	}

	public void setDdCutofftitleDto(DdCutofftitleDto ddCutofftitleDto) {
		this.ddCutofftitleDto = ddCutofftitleDto;
	}

		
	//please add your business methods start
	// to do it
    //add your business method end
}
