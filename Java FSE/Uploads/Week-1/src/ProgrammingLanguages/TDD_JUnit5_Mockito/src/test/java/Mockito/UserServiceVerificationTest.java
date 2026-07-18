package Mockito;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class UserServiceVerificationTest {

    @Test
    void testVerifyInteraction() {

        ExternalApi api = mock(ExternalApi.class);

        when(api.getUserName(1))
                .thenReturn("Prakyat");

        UserService service = new UserService(api);

        service.fetchUser(1);

        verify(api).getUserName(1);
    }
}