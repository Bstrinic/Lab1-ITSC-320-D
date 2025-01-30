package ca.sait.crs.factories;

import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ca.sait.crs.contracts.Course;
import ca.sait.crs.exceptions.CannotCreateCourseException;
import ca.sait.crs.services.CourseService;

/**
 * Creates course instances.
 * 
 * @author Nick Hamnett <nick.hamnett@sait.ca>
 * @since June 1, 2023
 */
public class CourseFactory {

    public CourseFactory() {
    }

    /**
     * Builds a Course instance
     * 
     * @param code    Course code
     * @param name    Name of course
     * @param credits Number of credits for course
     * @return RequiredCourse or OptionalCourse instance
     */
    public Course build(String code, String name, int credits) throws CannotCreateCourseException {
        if (!this.validateCode(code)) {
            throw new CannotCreateCourseException("Course code is invalid.");
        }

        if (!this.validateName(name)) {
            throw new CannotCreateCourseException("Course name is invalid.");
        }

        if (!this.validateCredits(credits)) {
            throw new CannotCreateCourseException("Course credits is invalid.");
        }

        return null;
    }

    /**
     * Checks the course code is valid.
     * 
     * @param code Course code
     * @return True if the course code is valid.
     */
    private boolean validateCode(String code) {
        // TODO: Add logic to test code is valid.
        String regex = "[A-Z]{4}-\\d{3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(code);
        return matcher.matches();
    }

    /**
     * Validates course name
     * 
     * @param name Course name
     * @return True if course name is valid.
     */
    private boolean validateName(String name) {
        // TODO: Add logic to test name is valid.
        if (name == null || name.length() < 5 || name.length() > 100) {
            return false;
        }
        return true; 
    }

    /**
     * Validates course credits
     * 
     * @param credits Course credits
     * @return True if credits value is valid.
     */
    private boolean validateCredits(int credits) {
        // TODO: Add logic to test credits is valid.
        return credits == 3 || credits == 0;
    }
}
