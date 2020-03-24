package lv.accenture.bootcamp.rardb4.service;

import lv.accenture.bootcamp.rardb4.model.Role;
import lv.accenture.bootcamp.rardb4.model.User;
import lv.accenture.bootcamp.rardb4.repository.RoleRepository;
import lv.accenture.bootcamp.rardb4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private DelegatingPasswordEncoder delegatingPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       DelegatingPasswordEncoder delegatingPasswordEncoder

    ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.delegatingPasswordEncoder=delegatingPasswordEncoder;

    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public User saveUser(User user) {
        user.setPassword(delegatingPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }
    public User saveAdmin(User user) {
        user.setPassword(delegatingPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

}