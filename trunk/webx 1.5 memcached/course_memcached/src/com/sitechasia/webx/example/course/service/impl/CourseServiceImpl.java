package com.sitechasia.webx.example.course.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.sitechasia.webx.example.course.dao.CourseDao;
import com.sitechasia.webx.example.course.model.Course;
import com.sitechasia.webx.example.course.service.CourseService;

public class CourseServiceImpl implements CourseService {

	private CourseDao courseDao;

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	@Transactional
	public void store(Course course) {
		courseDao.store(course);
	}

	@Transactional
	public void delete(Long courseId) {

		courseDao.delete(courseId);
	}

	@Transactional(readOnly = true)
	public Course findById(Long courseId) {
		return courseDao.findById(courseId);
	}

	@Transactional(readOnly = true)
	public List<Course> findAll() {
		return courseDao.findAll();
	}

}
