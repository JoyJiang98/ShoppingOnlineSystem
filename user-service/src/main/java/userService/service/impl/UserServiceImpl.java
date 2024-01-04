package userService.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userService.model.User;
import userService.repository.UserRepository;
import userService.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override public User save(User user) {
        return userRepository.save(user);
    }
}
