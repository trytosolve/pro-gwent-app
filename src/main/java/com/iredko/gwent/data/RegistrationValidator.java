package com.iredko.gwent.data;


import com.iredko.gwent.models.RegistrationForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class RegistrationValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return RegistrationForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegistrationForm registrationForm = (RegistrationForm) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"userLogin","userLogin.empty","Login must not be empty.");
        String username = registrationForm.getUserLogin();
        if ((username.length()) > 16) {
            errors.rejectValue("userLogin","userLogin.tooLong","Login must not more than 16 characters.");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPassword", "userPassword.empty", "Password must not be empty.");
        if (!(registrationForm.getUserPassword()).equals(registrationForm
                .getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "confirmPassword.passwordDontMatch", "Passwords don't match.");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userEmail", "userEmail.empty", "Email must not be empty.");

    }
}
