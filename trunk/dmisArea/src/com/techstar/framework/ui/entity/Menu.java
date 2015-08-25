package com.techstar.framework.ui.entity;

import java.util.List;

public class Menu {
	List childItems;//menu下的items
    public Menu(){
    	
    }
    public Menu(List childItems){
    	this.childItems = childItems;
    }
	public List getChildItems() {
		return childItems;
	}

	public void setChildItems(List childItems) {
		this.childItems = childItems;
	}

}
