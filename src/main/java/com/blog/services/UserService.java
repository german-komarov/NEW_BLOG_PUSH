package com.blog.services;

import com.blog.entities.Role;
import com.blog.entities.Users;
import com.blog.repositories.RoleRepository;
import com.blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Service
public class UserService implements UserDetailsService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByUsername(username);

        if (users == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return users;
    }

    public Users findUserById(long userId) {
        Optional<Users> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new Users());
    }

    public List<Users> allUsers() {
        return userRepository.findAll();
    }

    public boolean saveUser(Users users) {

        users.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        userRepository.save(users);
        return true;
    }

    public boolean deleteUser(long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public List<Users> usergtList(long idMin) {
        return em.createQuery("SELECT u FROM Users u WHERE u.id > :paramId", Users.class)
                .setParameter("paramId", idMin).getResultList();
    }

    public void makeModerator(long id)
    {
        Users users=findUserById(id);
        Set<Role> roles= users.getRoles();
        roles.add(new Role(2L,"ROLE_MODERATOR"));
        users.setRoles(roles);
        userRepository.save(users);
    }

    public void deleteModerator(long id)
    {
        Users users=findUserById(id);
        Set<Role> roles=users.getRoles();
        roles.removeIf(role -> role.getName().equals("ROLE_MODERATOR"));
        users.setRoles(roles);
        userRepository.save(users);

    }

    public Users findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }
}