package com.sitechasia.webx.example.course.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao;
import com.sitechasia.webx.example.course.dao.CourseDao;
import com.sitechasia.webx.example.course.model.Course;

public class CourseHibernateDaoImpl extends BaseHibernateDomainDao<Course>
		implements CourseDao {

	public void store(Course course) {
		this.save(course);
	}

	public void delete(Long courseId) {
		this.deleteById(courseId);
	}

	public Course findById(Long courseId) {
		return this.get(courseId);
	}

	public List<Course> findAll() {
		Query query = this.getSession().createQuery("from Course");
		// return query.list();
		return query.setCacheable(true).list();

		// return listAll(0, 0);
	}
}
