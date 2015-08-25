package com.apress.springrecipes.course;

import java.util.GregorianCalendar;

public class MainTestForOsgi {

	private CourseDao courseDao;

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	public void start() {

		Course course = new Course();
		course.setTitle("Core Spring");
		course.setBeginDate(new GregorianCalendar(2007, 8, 1).getTime());
		course.setEndDate(new GregorianCalendar(2007, 9, 1).getTime());
		course.setFee(1000);
		courseDao.store(course);
	}

	public void stop() {
		System.out.println("stop...");
	}

}
