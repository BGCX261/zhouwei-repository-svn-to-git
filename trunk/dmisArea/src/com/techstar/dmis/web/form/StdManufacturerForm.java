package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.StdManufacturerDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class StdManufacturerForm extends BaseForm {
	
	private StdManufacturerDto stdManufacturerDto = new StdManufacturerDto();

	
		
	public StdManufacturerForm() {

	}

	public StdManufacturerDto getStdManufacturerDto() {
		return stdManufacturerDto;
	}

	public void setStdManufacturerDto(StdManufacturerDto stdManufacturerDto) {
		this.stdManufacturerDto = stdManufacturerDto;
	}

		
	//please add your business methods start
	// to do it
    //add your business method end
}
