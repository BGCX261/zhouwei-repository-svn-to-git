package com.sitechasia.webx.example.course.service;

import java.util.List;

import com.sitechasia.webx.core.service.IService;
import com.sitechasia.webx.example.course.model.Course;

public interface CourseService extends IService{

    public void store(Course course);
    public void delete(Long courseId);
    public Course findById(Long courseId);
    public List<Course> findAll();
}
