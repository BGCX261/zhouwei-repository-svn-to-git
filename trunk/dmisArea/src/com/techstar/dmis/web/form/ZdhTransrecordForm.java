package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.ZdhTransrecordDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class ZdhTransrecordForm extends BaseForm {
	
	private ZdhTransrecordDto zdhTransrecordDto = new ZdhTransrecordDto();

	
				      private FormFile annexsequence;
	   		
	public ZdhTransrecordForm() {

	}

	public ZdhTransrecordDto getZdhTransrecordDto() {
		if(zdhTransrecordDto.getZzdhtransrecord3() ==null){
			com.techstar.dmis.dto.ZdhAutoondutylogDto zzdhtransrecord3= new com.techstar.dmis.dto.ZdhAutoondutylogDto();
			zdhTransrecordDto.setZzdhtransrecord3(zzdhtransrecord3);
		}
		if(zdhTransrecordDto.getZzdhtransrecord1() ==null){
			com.techstar.dmis.dto.StdStationDto zzdhtransrecord1= new com.techstar.dmis.dto.StdStationDto();
			zdhTransrecordDto.setZzdhtransrecord1(zzdhtransrecord1);
		}
		return zdhTransrecordDto;
	}

	public void setZdhTransrecordDto(ZdhTransrecordDto zdhTransrecordDto) {
		if(zdhTransrecordDto.getZzdhtransrecord3() ==null){
			com.techstar.dmis.dto.ZdhAutoondutylogDto zzdhtransrecord3= new com.techstar.dmis.dto.ZdhAutoondutylogDto();
			zdhTransrecordDto.setZzdhtransrecord3(zzdhtransrecord3);
		}
		if(zdhTransrecordDto.getZzdhtransrecord1() ==null){
			com.techstar.dmis.dto.StdStationDto zzdhtransrecord1= new com.techstar.dmis.dto.StdStationDto();
			zdhTransrecordDto.setZzdhtransrecord1(zzdhtransrecord1);
		}
		this.zdhTransrecordDto = zdhTransrecordDto;
	}
						
	public FormFile getAnnexsequence() {
		return annexsequence;
	}

	public void setAnnexsequence(FormFile annexsequence) {
		this.annexsequence = annexsequence;
	}
			
	//please add your business methods start
	// to do it
    //add your business method end
}
