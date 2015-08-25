package com.sitechasia.webx.example.course.dao;

import java.util.List;

import com.sitechasia.webx.example.course.model.Course;

public interface CourseDao {

    public void store(Course course);
    public void delete(Long courseId);
    public Course findById(Long courseId);
    public List<Course> findAll();
}
