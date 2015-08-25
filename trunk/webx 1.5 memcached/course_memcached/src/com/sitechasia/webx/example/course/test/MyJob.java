package com.sitechasia.webx.example.course.test;

import java.util.List;
import com.sitechasia.webx.example.course.model.Course;
import com.sitechasia.webx.example.course.service.CourseService;

public class MyJob {

	private CourseService courseService;

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public void run() {
		System.out
				.println("********************************************************************");
		List<Course> courses = courseService.findAll();
		Long courseId = courses.get(0).getId();

		Course course = courseService.findById(courseId);
		System.out.println("Course Title: " + course.getTitle());
		System.out.println("Begin Date: " + course.getBeginDate());
		System.out.println("End Date: " + course.getEndDate());
		System.out.println("Fee: " + course.getFee());

	}

}
