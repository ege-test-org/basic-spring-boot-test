package com.meryemefe.basic_spring_boot_test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Enrollment Service Tests")
class EnrollmentServiceTests {

	private final EnrollmentService enrollmentService = new EnrollmentService();

	@Test
	@DisplayName("Student with exact prerequisite credits should be eligible")
	void studentWithExactPrerequisiteCreditsShouldBeEligible() {
		Student student = new Student("S-100", 30);
		Course course = new Course("CS101", 30);

		assertTrue(
			enrollmentService.canEnroll(student, course),
			"Expected student with exact prerequisite credits to be eligible"
		);
	}

	@Test
	@DisplayName("Student below prerequisite credits should not be eligible")
	void studentBelowPrerequisiteCreditsShouldNotBeEligible() {
		Student student = new Student("S-101", 29);
		Course course = new Course("CS101", 30);

		assertFalse(enrollmentService.canEnroll(student, course));
	}
}
