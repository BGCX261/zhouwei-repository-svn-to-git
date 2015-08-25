package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.StdElectricstampDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class StdElectricstampForm extends BaseForm {
	
	private StdElectricstampDto stdElectricstampDto = new StdElectricstampDto();

	
				      private FormFile fgraph;
	   		
	public StdElectricstampForm() {

	}

	public StdElectricstampDto getStdElectricstampDto() {
		return stdElectricstampDto;
	}

	public void setStdElectricstampDto(StdElectricstampDto stdElectricstampDto) {
		this.stdElectricstampDto = stdElectricstampDto;
	}

						
	public FormFile getFgraph() {
		return fgraph;
	}

	public void setFgraph(FormFile fgraph) {
		this.fgraph = fgraph;
	}
			
	//please add your business methods start
	// to do it
    //add your business method end
}
