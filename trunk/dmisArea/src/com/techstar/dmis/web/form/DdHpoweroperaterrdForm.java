package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.DdClassondutylogDto;
import com.techstar.dmis.dto.DdHpoweroperaterrdDto;
import com.techstar.dmis.dto.StdStationDto;
//please add your business methods start
	// to do it
//add your business method end
import com.techstar.dmis.dto.EtsEquipmentDto;

/**
 * @author 
 * @date
 */
public class DdHpoweroperaterrdForm extends BaseForm {
	
	private DdHpoweroperaterrdDto ddHpoweroperaterrdDto = new DdHpoweroperaterrdDto();

	
		
	public DdHpoweroperaterrdForm() {

	}

	public DdHpoweroperaterrdDto getDdHpoweroperaterrdDto() {
		DdClassondutylogDto dcc = ddHpoweroperaterrdDto.getZddhpoweroperaterrd5();
		StdStationDto ded = ddHpoweroperaterrdDto.getZddhpoweroperaterrd2();
		
		if(dcc==null){
			dcc = new DdClassondutylogDto();
			ddHpoweroperaterrdDto.setZddhpoweroperaterrd5(dcc);
		}
		if(ded==null){
			ded = new StdStationDto();
			ddHpoweroperaterrdDto.setZddhpoweroperaterrd2(ded);
		}
		return ddHpoweroperaterrdDto;
	}

	public void setDdHpoweroperaterrdDto(DdHpoweroperaterrdDto ddHpoweroperaterrdDto) {
		DdClassondutylogDto dcc = ddHpoweroperaterrdDto.getZddhpoweroperaterrd5();
		StdStationDto ded = ddHpoweroperaterrdDto.getZddhpoweroperaterrd2();
		
		if(dcc==null){
			dcc = new DdClassondutylogDto();
			ddHpoweroperaterrdDto.setZddhpoweroperaterrd5(dcc);
		}
		if(ded==null){
			ded = new StdStationDto();
			ddHpoweroperaterrdDto.setZddhpoweroperaterrd2(ded);
		}
		this.ddHpoweroperaterrdDto = ddHpoweroperaterrdDto;
	}

		
	//please add your business methods start
	// to do it
    //add your business method end
}
