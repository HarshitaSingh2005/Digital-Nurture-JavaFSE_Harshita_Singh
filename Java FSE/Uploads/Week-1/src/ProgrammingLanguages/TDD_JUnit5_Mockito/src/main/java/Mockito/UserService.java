package Mockito;

public class UserService {

    private final ExternalApi api;

    public UserService(ExternalApi api) {
        this.api = api;
    }

    public String fetchUser(int id) {
        return api.getUserName(id);
    }
}