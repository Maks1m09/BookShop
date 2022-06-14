package by.tms.bookshop.service;
import by.tms.bookshop.entity.User;
import by.tms.bookshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public User findUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public User findUserByName(String name) {
        return userRepository.findByUserName(name);
    }

    public boolean saveUser(User user) {
        userRepository.save(user);
        return true;
    }

    public Optional<User> findUserById(long id) {
        Optional<User> user = userRepository.findById(id);
        return user;

    }

    public boolean deleteUser(User user) {
        if (user != null) {
            userRepository.delete(user);
            return true;
        }
        return false;
    }

    public Iterable<User> allUsers() {
        return userRepository.findAll();
    }

    public boolean createUser(Long id) {
        if (id != null) {
            userRepository.existsById(id);
            return true;
        }
        return false;
    }

    public Optional<User> findUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

}
