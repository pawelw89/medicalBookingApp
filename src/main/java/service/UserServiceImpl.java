package service;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service ("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByPesel(int pesel) {
        return userRepository.getOne(pesel);
    }

    @Override
    public User updateUser(int pesel, User user) {
        User userFromDatabase = userRepository.getOne(pesel);
        userFromDatabase.setFirstName(user.getFirstName());
        userFromDatabase.setSurname(user.getSurname());
        // nie wiem czy w ten sposób ustawię adress...
        userFromDatabase.setAdress(user.getAdress());
        // ustawianie ról również?
        userRepository.flush();
        User updatedUser = userRepository.getOne(pesel);
        return updatedUser;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserByPesel(int pesel) {
        userRepository.deleteById(pesel);
    }
}
