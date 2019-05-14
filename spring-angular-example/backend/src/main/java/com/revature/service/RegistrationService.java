package com.revature.service;

import com.revature.model.User;
import com.revature.model.dto.RegistrationForm;

/**
 * @author William Gentry
 */
public interface RegistrationService {

    User attemptRegistration(RegistrationForm registrationForm);
}
