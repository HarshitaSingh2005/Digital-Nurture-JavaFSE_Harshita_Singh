package Mockito;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceMockingTest {

    @Test
    void testMocking() {

        ExternalApi api = mock(ExternalApi.class);

        when(api.getUserName(1))
                .thenReturn("Prakyat");

        UserService service = new UserService(api);

        assertEquals("Prakyat", service.fetchUser(1));
    }
}