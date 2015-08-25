package com.sitechasia.webx.core.web.i18n;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimerTask;

import org.springframework.beans.factory.InitializingBean;

import org.apache.log4j.Logger;

public class DaemonThread extends TimerTask implements InitializingBean {
	private final Logger logger = Logger.getLogger(DaemonThread.class);

	private List<Reloadable> messageProvider = new ArrayList<Reloadable>();

	private List<Reloadable> globalMessageProvider = new ArrayList<Reloadable>();

	public void regiester(Reloadable reloadable){

		if(!messageProvider.contains(reloadable)&&(reloadable instanceof I18nMessageProvider)){

			messageProvider.add(reloadable);
		}

		if(reloadable instanceof I18nGlobalMessageProvider){

			globalMessageProvider.add(reloadable);
		}

	}

	public void run() {

		logger.info("time======"+new Date()+"======后台任务执行针对资源文件的检查");

		Iterator<Reloadable> iterlocal = messageProvider.iterator();

		while(iterlocal.hasNext()){

			iterlocal.next().check();
		}

		Iterator<Reloadable> itergolbal = globalMessageProvider.iterator();

		while(itergolbal.hasNext()){

			itergolbal.next().check();
		}
	}

	public void afterPropertiesSet() throws Exception {
		DaemonProvider.setDaemonInstance(this);

	}

}
