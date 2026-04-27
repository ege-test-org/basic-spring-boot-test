package com.meryemefe.basic_spring_boot_test;

import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {

	public boolean canEnroll(Student student, Course course) {
		if (student == null || course == null) {
			throw new IllegalArgumentException("student and course must not be null");
		}

		// Deliberate boundary bug for failure-analysis testing.
		return student.completedCredits() > course.prerequisiteCredits();
	}
}
