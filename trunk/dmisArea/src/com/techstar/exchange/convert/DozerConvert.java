package com.techstar.exchange.convert;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import net.sf.dozer.util.mapping.DozerBeanMapper;

import com.techstar.exchange.dto.TransDto;
import com.techstar.exchange.dto.TransSubDto;
import com.techstar.exchange.dto.bussiness.BussDto;
import com.techstar.exchange.dto.bussiness.BussSubDto;
import com.techstar.exchange.transfers.utils.MessageConfig;
import com.thoughtworks.xstream.XStream;

/**
 * @author xcf Apr 1, 2007 11:45:14 AM
 * 
 */
public class DozerConvert {
	/**
	 * 拷贝业务DTO信息到传输DTO中
	 * 
	 * @param buss
	 * @param sign
	 * @return
	 * @throws Exception
	 */
	public static Object bussToTrans(Object buss, String sign) throws Exception {
		List mappingFiles = new ArrayList();
		String transDtoName = "Trans" + sign + "Dto";
		mappingFiles.add("file:"+MessageConfig.getValue("mappingFileHome")+"Trans" + sign + ".xml");
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(mappingFiles);
		Object o = mapper.map(buss, MessageConfig
				.getTransDtoClassByName(transDtoName));
		return o;
	}

	/**
	 * 拷贝传输DTO信息到业务DTO中
	 * 
	 * @param trans
	 * @param sign
	 * @return
	 * @throws Exception
	 */
	public static Object transToBuss(Object trans, String sign)
			throws Exception {
		List mappingFiles = new ArrayList();
		String bussDtoName = sign + "Dto";
		mappingFiles.add("file:"+MessageConfig.getValue("mappingFileHome")+"Trans" + sign + ".xml");
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(mappingFiles);
		Object o = mapper.map(trans, MessageConfig
				.getBussDtoClassByName(bussDtoName));
		return o;
	}

	
	
	
	public static void main(String[] args) {
		BussDto bs = new BussDto();
		bs.setFapprovbookno("11");
		bs.setFgenerationtime(new Date(System.currentTimeMillis()));
		bs.setFprojectname("name");
		bs.setFstationname("fstationname");
		BussSubDto bss = new BussSubDto();
		bss.setId("00000000");
		bs.setSubDto(bss);

		List subs = new ArrayList();
		for (int i = 0; i < 3; i++) {
			BussSubDto bss1 = new BussSubDto();
			bss1.setFvoltage("fv" + i);
			subs.add(bss1);
		}
		bs.setSubDtos(subs);

		List myMappingFiles = new ArrayList();
		myMappingFiles.add("file:E:\\work\\DmisExchange\\src\\com\\techstar\\exchange\\dto\\mapping\\bussmapping.xml");
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(myMappingFiles);
		TransDto ts = (TransDto) mapper.map(bs, TransDto.class);

		System.out.println(ts.getFapprovbookno());
		System.out.println(ts.getSubDtoId());
		if (ts.getSubDtos() != null) {
			for (int i = 0; i < ts.getSubDtos().size(); i++) {
				TransSubDto sub = (TransSubDto) ts.getSubDtos().get(i);
				System.out.println(sub.getFvoltage());
			}
		}
	}
}
