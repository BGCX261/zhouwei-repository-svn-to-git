package com.techstar.framework.ui.web.tag.engine;

import java.util.LinkedList;

public class Row {
	
	private int id;
	private LinkedList cells = new LinkedList();

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LinkedList getCells() {
		return cells;
	}

	public void setCells(LinkedList cells) {
		this.cells = cells;
	}
	
	public void addCell(Cell c){
		cells.addLast(c);
	}

}
