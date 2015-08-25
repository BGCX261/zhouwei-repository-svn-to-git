package com.apress.springrecipes.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class MyJob {

	private CourseDao courseDao;

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	public void run() {
		System.out
				.println("********************************************************************");
		List<Course> courses = courseDao.findAll();
		Long courseId = courses.get(0).getId();

		Course course = courseDao.findById(courseId);
		System.out.println("Course Title: " + course.getTitle());
		System.out.println("Begin Date: " + course.getBeginDate());
		System.out.println("End Date: " + course.getEndDate());
		System.out.println("Fee: " + course.getFee());

	}

}
