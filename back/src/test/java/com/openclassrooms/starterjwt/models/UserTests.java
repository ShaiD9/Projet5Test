package com.openclassrooms.starterjwt.models;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.platform.engine.TestTag.isValid;

@ExtendWith(MockitoExtension.class)
public class UserTests {

    @Nested
    class email {
        @Test
        public void emailNonNull() {
            User user = new User();
            user.setEmail("test@gmail.com");

            boolean validationResult = isValid(user.getEmail());

            assertTrue(validationResult);
        }

        @Test
        void emailShouldBeLessThan50() {
            User user = new User();
            user.setEmail("test@gmail.com");

            assertTrue(user.getEmail().length() <= 50);
        }

        @Test
        void emailShouldBeMoreThan50() {
            User user = new User();
            user.setEmail("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz@example.fr");

            assertFalse(user.getEmail().length() <= 50);
        }
    }

    @Nested
    class lastname {
        @Test
        public void lastnameNonNull() {
            User user = new User();
            user.setLastName("Test");

            boolean validationResult = isValid(user.getLastName());

            assertTrue(validationResult);
        }

        @Test
        void lastNameShouldBeLessThan20() {
            User user = new User();
            user.setLastName("Test");
            assertTrue(user.getLastName().length() <= 20);
        }

        @Test
        void lastNameShouldNotBeMoreThan20() {
            User user = new User();
            user.setLastName("uegroqsihesouirldghsend");
            assertFalse(user.getLastName().length() <= 20);
        }
    }

    @Nested
    class firstname {
        @Test
        public void firstnameNonNull() {
            User user = new User();
            user.setFirstName("Test");

            boolean validationResult = isValid(user.getFirstName());

            assertTrue(validationResult);
        }

        @Test
        void firstNameShouldBeLessThan20() {
            User user = new User();
            user.setFirstName("Test");
            assertTrue(user.getFirstName().length() <= 20);
        }

        @Test
        void firstNameShouldNotBeMoreThan20() {
            User user = new User();
            user.setFirstName("pazodeqisfujhglsjkqzelswdxc");
            assertFalse(user.getFirstName().length() <= 20);
        }
    }

    @Nested
    class password {
        @Test
        public void passwordNonNull() {
            User user = new User();
            user.setPassword("Test");

            boolean validationResult = isValid(user.getPassword());

            assertTrue(validationResult);
        }

        @Test
        void passwordShouldBeLessThan120() {
            User user = new User();
            user.setPassword("PassWORD");
            assertTrue(user.getPassword().length() <= 120);
        }

        @Test
        void passwordShouldNotBeMoreThan120() {
            User user = new User();
            user.setPassword("zeoprfigdtjhbkuliotsrpeghdfjotrkjehdbnfgjkuiulroresjfdgilugorsehrdjngljuiosertkjgkzesirdotlfmbjmolkrtmoklkgjsdfmgibolijetdromflbkgdmtrofilonjdmtoltkhjdrmfc");
            assertFalse(user.getPassword().length() <= 120);
        }
    }

    @Test
    public void adminNotNull() {
        User user = new User();
        user.setAdmin(true);

        boolean validationResult = isValid(String.valueOf(user.isAdmin()));

        assertTrue(validationResult);
    }
}
