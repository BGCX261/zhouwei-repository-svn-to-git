package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.DdEnsuringpsmanageDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class DdEnsuringpsmanageForm extends BaseForm {
	
	private DdEnsuringpsmanageDto ddEnsuringpsmanageDto = new DdEnsuringpsmanageDto();

	
				      private FormFile fcommunication;
	   	      private FormFile fmeasarule;
	   	      private FormFile fadditonal;
	   		
	public DdEnsuringpsmanageForm() {

	}

	public DdEnsuringpsmanageDto getDdEnsuringpsmanageDto() {
		return ddEnsuringpsmanageDto;
	}

	public void setDdEnsuringpsmanageDto(DdEnsuringpsmanageDto ddEnsuringpsmanageDto) {
		this.ddEnsuringpsmanageDto = ddEnsuringpsmanageDto;
	}

						
	public FormFile getFcommunication() {
		return fcommunication;
	}

	public void setFcommunication(FormFile fcommunication) {
		this.fcommunication = fcommunication;
	}
				
	public FormFile getFmeasarule() {
		return fmeasarule;
	}

	public void setFmeasarule(FormFile fmeasarule) {
		this.fmeasarule = fmeasarule;
	}
				
	public FormFile getFadditonal() {
		return fadditonal;
	}

	public void setFadditonal(FormFile fadditonal) {
		this.fadditonal = fadditonal;
	}
			
	//please add your business methods start
	// to do it
    //add your business method end
}
