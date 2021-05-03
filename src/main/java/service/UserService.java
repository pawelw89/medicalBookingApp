package service;

import entity.Doctor;
import entity.Reservation;
import entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserByPesel (int pesel);

    User updateUser (int pesel, User user);

    User saveUser (User user);

    void deleteUserByPesel (int pesel);
}
