package com.TranquilMind.service;

import com.TranquilMind.dto.CourseDto;
import com.TranquilMind.model.Course;
import java.util.List;
public interface CourseService {

    List<Course> getAllCourses();

    Course getCourseById(Long id);

    Course updateCourse(Long id, Course course);

    Course addCourse(CourseDto courseDto);



}
