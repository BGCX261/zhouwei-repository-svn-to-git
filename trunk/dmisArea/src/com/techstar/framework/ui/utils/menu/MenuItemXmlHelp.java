package com.techstar.framework.ui.utils.menu;

import java.util.*;
import com.techstar.framework.ui.entity.Menu;
import com.techstar.framework.ui.entity.MenuItem;

public class MenuItemXmlHelp {
	
	private String lineFlag ="";
	public MenuItemXmlHelp(){
		
	}
	
	/**
	 * 把Menu对象转化为xml
	 * @param menu
	 * @return
	 */
	public String  getMenuXml(Menu menu){
	
		List chilitems = menu.getChildItems();
		String menuXml ="<?xml version='1.0' encoding='utf-8'?>";
		menuXml +="<Menu>";
		
		if(chilitems!=null&&chilitems.size()>0){
			for(int i=0;i<chilitems.size();i++){
				menuXml +=this.tranItemToXml((MenuItem)chilitems.get(i));
			}
		}
		
		menuXml +="</Menu>";
		return menuXml;
	}
	
	
	/**
	 * 把MenuItem　对象转化为xml
	 * @param item
	 * @return
	 */
	private String tranItemToXml(MenuItem item){
		
		/*
		 * 	<MenuItem Text="DEMO" id="demo">
	 			<MenuItem Text="UI控件" src="" id="demo0" href="/ui.do?method=initFrame" title="UI控件">
				</MenuItem>
				<MenuItem Text="工具栏+普通数据页" src="" id="demo1" href="/rijihua.do?method=initFrame1">
				</MenuItem>
	 
		 		<MenuItem Text="工具栏+Tab页" src="" id="demo2" href="/rijihua.do?method=initFrame2">
				</MenuItem>
				<MenuItem Text="树+普通数据页" src="" id="demo3" href="/rijihua.do?method=initFrame3">
				</MenuItem> 
			</MenuItem>
		 */
		String itemXml ="";
		try{
			 itemXml = "<MenuItem ";
			
			itemXml += "Text ='"+ item.getText()+"' ";
			itemXml += "id ='"+ item.getId()+"' ";
			itemXml += "href ='"+ item.getHref()+"' ";
			itemXml +=  "title ='"+ item.getTitle()+"' >"+lineFlag;
			List children = item.getChildren();
			if(children!=null&&children.size()>0){
				for(int i=0;i<children.size();i++){
					itemXml +=tranItemToXml((MenuItem)children.get(i));
				}
			}
			
			itemXml +="</MenuItem>"+lineFlag;
		}catch(Exception e){
			e.printStackTrace();
		}
		return itemXml;
	}

	public static  void  main(String[] args){
		MenuItem item1 = new MenuItem();
		item1.setText("DEMO");
		item1.setId("demo");
		List item1s = new ArrayList();
		
		MenuItem item2 = new MenuItem();
		item2.setText("UI控件");
		item2.setId("demo0");
		item2.setHref("/ui.do?method=initFrame");
		item2.setTitle("fffff");
		
		List item2s = new ArrayList();
		
		MenuItem item4 = new MenuItem();
		item4.setText("UI控件4");
		item4.setId("demo4");
		item4.setHref("/ui.do?method=initFrame");
		item4.setTitle("fffff");
		
		List item4s = new ArrayList();
		MenuItem item6 = new MenuItem();
		item6.setText("UI控件6");
		item6.setId("demo6");
		item6.setHref("/ui.do?method=initFrame");
		item6.setTitle("fffff");
		item4s.add(item6);
		item4.setChildren(item4s);
		
		MenuItem item5 = new MenuItem();
		item5.setText("UI控件5");
		item5.setId("demo5");
		item5.setHref("/ui.do?method=initFrame");
		item5.setTitle("fffff");
		
		item2s.add(item4);
		item2s.add(item5);
		item2.setChildren(item2s);
		
		MenuItem item3 = new MenuItem();
		item3.setText("工具栏+普通数据页");
		item3.setId("demo4");
		item3.setHref("/ui.do?method=initFrame");
		item3.setTitle("ttttt");
		
		item1s.add(item2);
		item1s.add(item3);
		item1.setChildren(item1s);
		
		MenuItemXmlHelp help = new MenuItemXmlHelp();
		//String xml = help.tranItemToXml(item1);
		
		Menu  menu = new Menu();
		List menuList = new ArrayList();
		menuList.add(item1);
		menu.setChildItems(menuList);
		String xml = help.getMenuXml(menu);
		System.out.println(xml);
		
	}
}
