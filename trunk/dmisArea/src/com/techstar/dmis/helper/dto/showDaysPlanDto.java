package com.techstar.dmis.helper.dto;
import java.util.*;
public class showDaysPlanDto {

	 List  dayPlanworks = new ArrayList();
	 String today;
	 String minTime;
	 int  hours;
	 int  grids;
	public List getDayPlanworks() {
		return dayPlanworks;
	}
	public void setDayPlanworks(List dayPlanworks) {
		this.dayPlanworks = dayPlanworks;
	}
	public int getGrids() {
		return grids;
	}
	public void setGrids(int grids) {
		this.grids = grids;
	}
	public int getHours() {
		
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public String getMinTime() {
		return minTime;
	}
	public void setMinTime(String minTime) {
		this.minTime = minTime;
	}
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	
	public void addDayPlanWorkDto(DayPlanWorkDto o){
		this.dayPlanworks.add(o);
	}
	
	
}
