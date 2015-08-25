package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.StdStationDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class StdStationForm extends BaseForm {
	
	private StdStationDto stdStationDto = new StdStationDto();

	
		
	public StdStationForm() {

	}

	public StdStationDto getStdStationDto() {
		return stdStationDto;
	}

	public void setStdStationDto(StdStationDto stdStationDto) {
		this.stdStationDto = stdStationDto;
	}

		
	//please add your business methods start
	// to do it
    //add your business method end
}
