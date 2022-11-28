package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import java.util.List;
import java.util.Set;


public interface UserService extends UserDetailsService {


    void updateUser(User user, Set<Role> roles, int id);

    List<Role> listRoles();

    User getUserById(int id);

    List<User> getAllUsers();

    void saveUser(User user, Set<Role> roles);

    void deleteUserById(int id);

}
