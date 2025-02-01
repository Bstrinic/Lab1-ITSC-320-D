package ca.sait.crs.services;

import ca.sait.crs.contracts.RegistrationService;
import ca.sait.crs.contracts.Registration;
import ca.sait.crs.contracts.Student;
import ca.sait.crs.contracts.Course;
import ca.sait.crs.exceptions.CannotCreateRegistrationException;

import java.util.ArrayList;

// TODO: Define the ProxyRegistrationService
// TODO: Implement the RegistrationService interface
// TODO: Check student can be registered before passing to RealRegistrationService
// TODO: Make this class immutable.

public final class ProxyRegistrationService implements RegistrationService {
    private final RegistrationService realRegistrationService;

    public ProxyRegistrationService(RegistrationService realRegistrationService) {
        this.realRegistrationService = realRegistrationService;
    }

    @Override
    public Registration register(Student student, Course course) throws CannotCreateRegistrationException {
        if (student == null) {
            throw new CannotCreateRegistrationException("Invalid student name.");
        }

        if (course == null) {
            throw new CannotCreateRegistrationException("Invalid course code.");
        }

        if (student.getGpa() < 2.0) {
            throw new CannotCreateRegistrationException("Student GPA is too low thus ineligible to register.");
        }

        return realRegistrationService.register(student, course);
    }

    @Override
    public ArrayList<Registration> getRegistrations() {
        return realRegistrationService.getRegistrations();
    }
}