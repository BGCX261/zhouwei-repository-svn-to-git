package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.ZdhCharalterrecordDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class ZdhCharalterrecordForm extends BaseForm {
	
	private ZdhCharalterrecordDto zdhCharalterrecordDto = new ZdhCharalterrecordDto();

	
				      private FormFile mdiagram;
	   		
	public ZdhCharalterrecordForm() {

	}

	public ZdhCharalterrecordDto getZdhCharalterrecordDto() {
		return zdhCharalterrecordDto;
	}

	public void setZdhCharalterrecordDto(ZdhCharalterrecordDto zdhCharalterrecordDto) {
		this.zdhCharalterrecordDto = zdhCharalterrecordDto;
	}

						
	public FormFile getMdiagram() {
		return mdiagram;
	}

	public void setMdiagram(FormFile mdiagram) {
		this.mdiagram = mdiagram;
	}
			
	//please add your business methods start
	// to do it
    //add your business method end
}
