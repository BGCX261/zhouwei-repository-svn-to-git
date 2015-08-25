package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.ZdhSrapplicationDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class ZdhSrapplicationForm extends BaseForm {
	
	private ZdhSrapplicationDto zdhSrapplicationDto = new ZdhSrapplicationDto();

	
				      private FormFile fannexexplanation;
	   		
	public ZdhSrapplicationForm() {

	}

	public ZdhSrapplicationDto getZdhSrapplicationDto() {
		return zdhSrapplicationDto;
	}

	public void setZdhSrapplicationDto(ZdhSrapplicationDto zdhSrapplicationDto) {
		this.zdhSrapplicationDto = zdhSrapplicationDto;
	}

						
	public FormFile getFannexexplanation() {
		return fannexexplanation;
	}

	public void setFannexexplanation(FormFile fannexexplanation) {
		this.fannexexplanation = fannexexplanation;
	}
			
	//please add your business methods start
	// to do it
    //add your business method end
}
