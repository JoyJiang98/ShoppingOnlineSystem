package userService.service;


import userService.model.User;

public interface UserService {
    User findByName(String name);

    User save(User user);
}
