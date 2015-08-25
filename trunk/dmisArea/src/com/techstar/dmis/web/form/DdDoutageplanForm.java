package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.DdDoutageplanDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class DdDoutageplanForm extends BaseForm {
	
	private DdDoutageplanDto ddDoutageplanDto = new DdDoutageplanDto();

	
			  private FormFile faddipicture;
	   	      private FormFile funmeasureannex;
	   		
	public DdDoutageplanForm() {

	}

	public DdDoutageplanDto getDdDoutageplanDto() {
		return ddDoutageplanDto;
	}

	public void setDdDoutageplanDto(DdDoutageplanDto ddDoutageplanDto) {
		this.ddDoutageplanDto = ddDoutageplanDto;
	}

						
	public FormFile getFaddipicture() {
		return faddipicture;
	}

	public void setFaddipicture(FormFile faddipicture) {
		this.faddipicture = faddipicture;
	}
				
	public FormFile getFunmeasureannex() {
		return funmeasureannex;
	}

	public void setFunmeasureannex(FormFile funmeasureannex) {
		this.funmeasureannex = funmeasureannex;
	}
			
	//please add your business methods start
	// to do it
    //add your business method end
}
