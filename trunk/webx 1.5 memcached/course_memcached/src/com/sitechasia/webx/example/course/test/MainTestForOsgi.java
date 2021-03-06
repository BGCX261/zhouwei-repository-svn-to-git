package com.sitechasia.webx.example.course.test;

import java.util.GregorianCalendar;
import java.util.List;
import com.sitechasia.webx.example.course.model.Course;
import com.sitechasia.webx.example.course.service.CourseService;

public class MainTestForOsgi {

	private CourseService courseService;

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public void start() {

		Course course = new Course();
		course.setTitle("Core Spring");
		course.setBeginDate(new GregorianCalendar(2007, 8, 1).getTime());
		course.setEndDate(new GregorianCalendar(2007, 9, 1).getTime());
		course.setFee(1000);
		courseService.store(course);

		List<Course> courses = courseService.findAll();
		Long courseId = courses.get(0).getId();

		course = courseService.findById(courseId);
		System.out.println("Course Title: " + course.getTitle());
		System.out.println("Begin Date: " + course.getBeginDate());
		System.out.println("End Date: " + course.getEndDate());
		System.out.println("Fee: " + course.getFee());

		courseService.delete(courseId);
	}

	public void stop() {
		System.out.println("stop...");
	}

}
