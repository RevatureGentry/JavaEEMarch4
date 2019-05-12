package com.revature.service;

import com.revature.exception.BadRegistrationAttemptException;
import com.revature.model.User;
import com.revature.model.dto.RegistrationForm;
import com.revature.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author William Gentry
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User attemptRegistration(RegistrationForm registrationForm) {
        // Make sure all fields are present
        if (registrationForm.getUsername() == null)
            throw new BadRegistrationAttemptException("username");
        if (registrationForm.getPassword() == null)
            throw new BadRegistrationAttemptException("password");
        if (registrationForm.getEmail() == null)
            throw new BadRegistrationAttemptException("email");
        if (registrationForm.getFirstname() == null)
            throw new BadRegistrationAttemptException("firstname");
        if (registrationForm.getLastname() == null)
            throw new BadRegistrationAttemptException("lastname");

        // Utilize static helper method on User class to generate User object from Registration Form
        final User registeringUser = User.fromRegistrationForm(registrationForm);

        // If all fields are present, hash the password and set the value
        final String hashedPassword = passwordEncoder.encode(registrationForm.getPassword());

        registeringUser.setPassword(hashedPassword);

        // Persist the user
        return userRepository.save(registeringUser);
    }
}
