package com.walmart.registration;

import org.springframework.stereotype.Service;
import org.apache.commons.validator.routines.EmailValidator;
import java.util.function.Predicate;

@Service
public class EmailAddressValidator implements Predicate<String> {

    @Override
    public boolean test(String emailAddress) {

        EmailValidator emailValidator = EmailValidator.getInstance();
        return emailValidator.isValid(emailAddress);
    }
}
