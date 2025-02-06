package guru.qa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import java.io.IOException;

public class RegistrationNewUserTest {

    @CsvSource ({
            "test980@test.ru, 1234567",
            "test981@test.ru, 1234567",
            "test982@test.ru, 1234567"

    }
    )
    @ParameterizedTest
    public void registrationNewUser (String userEmail, String password) throws IOException, InterruptedException {
        JUnitSimpleTest jUnitSimpleTest = new JUnitSimpleTest();
        jUnitSimpleTest.registrationNewUser(userEmail, password );
    }
}
