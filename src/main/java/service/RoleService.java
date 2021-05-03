package service;

import entity.Doctor;
import entity.Reservation;
import entity.Role;
import entity.User;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    List<Role> getAllRolesByUserId (long id);

    List<Role> getAllRolesByDoctorId (long id);

    Role updateRole (long id, Role role);

    Role saveRole (Role role);

    void deleteRoleById (long id);
}
