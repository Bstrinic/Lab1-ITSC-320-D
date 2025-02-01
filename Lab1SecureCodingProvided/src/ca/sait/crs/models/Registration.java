package ca.sait.crs.models;

import ca.sait.crs.contracts.Course;
import ca.sait.crs.contracts.Student;
import ca.sait.crs.exceptions.CannotCreateRegistrationException;

// TODO: Make this class immutable.

/**
 * Represents a registration.
 * @author Nick Hamnett <nick.hamnett@sait.ca>
 * @since June 1, 2023
 */
public final class Registration implements ca.sait.crs.contracts.Registration {
    /**
     * Associated course
     */
    private final Course course;
    /**
     * Associated student
     */
    private final Student student;

    /**
     * Initializes instance.
     * @param course Course instance
     * @param student Student instance
     */
    public Registration(Course course, Student student) {
        this.course = course;
        this.student = student;
    }

    /**
     * Gets the course.
     * @return Course
     */
    @Override
    public Course getCourse() {
        return course;
    }

    /**
     * Gets the student
     * @return Student
     */
    @Override
    public Student getStudent() {
        return student;
    }
}
