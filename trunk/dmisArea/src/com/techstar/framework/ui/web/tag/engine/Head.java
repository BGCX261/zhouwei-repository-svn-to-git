package com.techstar.framework.ui.web.tag.engine;

import java.util.LinkedList;


public class Head {

	private Obj obj;
	private LinkedList columns = new LinkedList();

	public Obj getObj() {
		return obj;
	}

	public void setObj(Obj obj) {
		this.obj = obj;
	}

	public LinkedList getColumns() {
		return columns;
	}

	public void setColumns(LinkedList columns) {
		this.columns = columns;
	}
	
	public void addColumn(Column c){
		columns.addLast(c);
	}	
	
}
