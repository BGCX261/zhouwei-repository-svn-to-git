package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.DaymodeanalyseDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class DaymodeanalyseForm extends BaseForm {
	
	private DaymodeanalyseDto daymodeanalyseDto = new DaymodeanalyseDto();

	
		
	public DaymodeanalyseForm() {

	}

	public DaymodeanalyseDto getDaymodeanalyseDto() {
		return daymodeanalyseDto;
	}

	public void setDaymodeanalyseDto(DaymodeanalyseDto daymodeanalyseDto) {
		this.daymodeanalyseDto = daymodeanalyseDto;
	}

		
	//please add your business methods start
	// to do it
    //add your business method end
}
