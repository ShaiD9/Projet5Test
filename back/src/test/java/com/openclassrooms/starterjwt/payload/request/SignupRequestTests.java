package com.openclassrooms.starterjwt.payload.request;

import com.openclassrooms.starterjwt.payload.request.SignupRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class SignupRequestTests {

    private Validator validator;
    private SignupRequest signupRequest;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        signupRequest = new SignupRequest();
    }

    @Nested
    class EmailTests {

        @Test
        void shouldSetAndGetEmail() {
            String email = "test@gmail.com";
            signupRequest.setEmail(email);

            assertEquals(email, signupRequest.getEmail());
        }

        @Test
        void shouldFailValidationWhenEmailIsTooLong() {
            String email = "abcdefsdsghijkqlmnopqrsdztuvwxyzdfdghgabcdefghijklmnopqrzestuvwxyzez@gmail.com";
            signupRequest.setEmail(email);

            Set<ConstraintViolation<SignupRequest>> violations = validator.validate(signupRequest);
            assertFalse(violations.isEmpty());
        }

        @Test
        void shouldFailValidationWhenEmailIsBlank() {
            signupRequest.setEmail("");

            Set<ConstraintViolation<SignupRequest>> violations = validator.validate(signupRequest);
            assertFalse(violations.isEmpty());
        }

        @Test
        void shouldFailValidationWhenEmailIsNull() {
            signupRequest.setEmail(null);

            Set<ConstraintViolation<SignupRequest>> violations = validator.validate(signupRequest);
            assertFalse(violations.isEmpty());
        }
    }

    @Nested
    class FirstNameTests {

        @Test
        void shouldSetAndGetFirstName() {
            String firstName = "Test";
            signupRequest.setFirstName(firstName);

            assertEquals(firstName, signupRequest.getFirstName());
        }

        @Test
        void shouldFailValidationWhenFirstNameIsTooShort() {
            String firstName = "te";
            signupRequest.setFirstName(firstName);

            Set<ConstraintViolation<SignupRequest>> violations = validator.validate(signupRequest);
            assertFalse(violations.isEmpty());
        }

        @Test
        void shouldFailValidationWhenFirstNameIsTooLong() {
            String firstName = "pzeodfrdgijtrlkzertftresdf";
            signupRequest.setFirstName(firstName);

            Set<ConstraintViolation<SignupRequest>> violations = validator.validate(signupRequest);
            assertFalse(violations.isEmpty());
        }

        @Test
        void shouldFailValidationWhenFirstNameIsBlank() {
            signupRequest.setFirstName("");

            Set<ConstraintViolation<SignupRequest>> violations = validator.validate(signupRequest);
            assertFalse(violations.isEmpty());
        }

        @Test
        void shouldFailValidationWhenFirstNameIsNull() {
            signupRequest.setFirstName(null);

            Set<ConstraintViolation<SignupRequest>> violations = validator.validate(signupRequest);
            assertFalse(violations.isEmpty());
        }
    }

    @Nested
    class LastNameTests {

        @Test
        void shouldSetAndGetLastName() {
            String lastName = "TEST";

            signupRequest.setLastName(lastName);
            assertEquals(lastName, signupRequest.getLastName());
        }

        @Test
        void shouldFailValidationWhenLastNameIsTooShort() {
            String lastName = "TE";
            signupRequest.setLastName(lastName);

            Set<ConstraintViolation<SignupRequest>> violations = validator.validate(signupRequest);
            assertFalse(violations.isEmpty());
        }

        @Test
        void shouldFailValidationWhenLastNameIsTooLong() {
            String lastName = "ESRDOFIJKLOFKESODIMXLKQJMIOSD";
            signupRequest.setLastName(lastName);

            Set<ConstraintViolation<SignupRequest>> violations = validator.validate(signupRequest);
            assertFalse(violations.isEmpty());
        }

        @Test
        void shouldFailValidationWhenLastNameIsBlank() {
            signupRequest.setLastName("");

            Set<ConstraintViolation<SignupRequest>> violations = validator.validate(signupRequest);
            assertFalse(violations.isEmpty());
        }

        @Test
        void shouldFailValidationWhenLastNameIsNull() {
            signupRequest.setLastName(null);

            Set<ConstraintViolation<SignupRequest>> violations = validator.validate(signupRequest);
            assertFalse(violations.isEmpty());
        }
    }

    @Nested
    class PasswordTests {

        @Test
        void shouldSetAndGetPassword() {
            String password = "password";
            signupRequest.setPassword(password);
            assertEquals(password, signupRequest.getPassword());
        }

        @Test
        void shouldFailValidationWhenPasswordIsTooShort() {
            String password = "poiu";
            signupRequest.setPassword(password);

            Set<ConstraintViolation<SignupRequest>> violations = validator.validate(signupRequest);
            assertFalse(violations.isEmpty());
        }

        @Test
        void shouldFailValidationWhenPasswordIsTooLong() {
            String password = "deofisprçhljezkisdfrnzlsqedsifvxjknckdwoimpqjefksfojivmsrzkeqdsifjmsrskzdoimfjsrzlk";
            signupRequest.setPassword(password);

            Set<ConstraintViolation<SignupRequest>> violations = validator.validate(signupRequest);
            assertFalse(violations.isEmpty());
        }

        @Test
        void shouldFailValidationWhenPasswordIsBlank() {
            signupRequest.setPassword("");

            Set<ConstraintViolation<SignupRequest>> violations = validator.validate(signupRequest);
            assertFalse(violations.isEmpty());
        }

        @Test
        void shouldFailValidationWhenPasswordIsNull() {
            signupRequest.setPassword(null);

            Set<ConstraintViolation<SignupRequest>> violations = validator.validate(signupRequest);
            assertFalse(violations.isEmpty());
        }
    }
}
