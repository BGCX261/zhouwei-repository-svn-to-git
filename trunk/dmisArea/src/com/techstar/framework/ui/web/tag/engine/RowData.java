package com.techstar.framework.ui.web.tag.engine;

import java.util.LinkedList;

public class RowData {

	private LinkedList rows = new LinkedList();

	public LinkedList getRows() {
		return rows;
	}

	public void setRows(LinkedList rows) {
		this.rows = rows;
	}
	
	public void addRow(Row r){
		rows.addLast(r);
	}
}
