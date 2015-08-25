package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.DdHloadrecordDto;
import com.techstar.dmis.dto.DdClassondutylogDto;
import com.techstar.dmis.dto.EtsEquipmentDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class DdHloadrecordForm extends BaseForm {
	
	private DdHloadrecordDto ddHloadrecordDto = new DdHloadrecordDto();

	
		
	public DdHloadrecordForm() {

	}

	public DdHloadrecordDto getDdHloadrecordDto() {
		
		DdClassondutylogDto dcc = ddHloadrecordDto.getZddhloadrecord4();
		EtsEquipmentDto ded = ddHloadrecordDto.getZddhloadrecord6();
		
		if(dcc==null){
			dcc = new DdClassondutylogDto();
			ddHloadrecordDto.setZddhloadrecord4(dcc);
		}
		if(ded==null){
			ded = new EtsEquipmentDto();
			ddHloadrecordDto.setZddhloadrecord6(ded);
		}
		
		return ddHloadrecordDto;
	}

	public void setDdHloadrecordDto(DdHloadrecordDto ddHloadrecordDto) {
		DdClassondutylogDto dcc = ddHloadrecordDto.getZddhloadrecord4();
		EtsEquipmentDto ded = ddHloadrecordDto.getZddhloadrecord6();
		
		if(dcc==null){
			dcc = new DdClassondutylogDto();
			ddHloadrecordDto.setZddhloadrecord4(dcc);
		}
		if(ded==null){
			ded = new EtsEquipmentDto();
			ddHloadrecordDto.setZddhloadrecord6(ded);
		}
		
		this.ddHloadrecordDto = ddHloadrecordDto;
	}

		
	//please add your business methods start
	// to do it
    //add your business method end
}
