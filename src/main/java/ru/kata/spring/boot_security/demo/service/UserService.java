package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import java.util.List;


public interface UserService extends UserDetailsService {


    void updateUser(User user);

    List<Role> listRoles();

    User getUserById(int id);

    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUserById(int id);

}
