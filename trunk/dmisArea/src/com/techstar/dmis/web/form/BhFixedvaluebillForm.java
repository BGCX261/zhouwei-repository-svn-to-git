package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.BhFixedvaluebillDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class BhFixedvaluebillForm extends BaseForm {
	
	private BhFixedvaluebillDto bhFixedvaluebillDto = new BhFixedvaluebillDto();

	
				      private FormFile fixvalueoriginal;
	   		
	public BhFixedvaluebillForm() {

	}

	public BhFixedvaluebillDto getBhFixedvaluebillDto() {
		return bhFixedvaluebillDto;
	}

	public void setBhFixedvaluebillDto(BhFixedvaluebillDto bhFixedvaluebillDto) {
		this.bhFixedvaluebillDto = bhFixedvaluebillDto;
	}

						
	public FormFile getFixvalueoriginal() {
		return fixvalueoriginal;
	}

	public void setFixvalueoriginal(FormFile fixvalueoriginal) {
		this.fixvalueoriginal = fixvalueoriginal;
	}
			
	//please add your business methods start
	// to do it
    //add your business method end
}
