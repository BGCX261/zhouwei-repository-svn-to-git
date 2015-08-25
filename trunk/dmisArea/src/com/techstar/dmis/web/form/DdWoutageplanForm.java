package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.DdWoutageplanDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class DdWoutageplanForm extends BaseForm {
	
	private DdWoutageplanDto ddWoutageplanDto = new DdWoutageplanDto();

	
		
	public DdWoutageplanForm() {

	}

	public DdWoutageplanDto getDdWoutageplanDto() {
		return ddWoutageplanDto;
	}

	public void setDdWoutageplanDto(DdWoutageplanDto ddWoutageplanDto) {
		this.ddWoutageplanDto = ddWoutageplanDto;
	}

		
	//please add your business methods start
	// to do it
    //add your business method end
}
