package com.walmart.registration;

import com.walmart.appuser.AppUser;
import com.walmart.appuser.AppUserRole;
import com.walmart.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private EmailValidator emailValidator;
    private final static String EMAIL_IS_NOT_VALID_MESSAGE = "Email is not valid";
    private final AppUserService appUserService;

    public String register(RegistrationRequest request) {

        boolean isValidEmail = emailValidator.test(request.getEmail());

        if(!isValidEmail)
            throw new IllegalArgumentException(request.getEmail() + " :" + EMAIL_IS_NOT_VALID_MESSAGE);

        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }
}
