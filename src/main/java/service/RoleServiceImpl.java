package service;

import entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RoleRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service ("roleService")
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public List<Role> getAllRolesByUserId(long id) {
        return roleRepository.listOfRolesByUserId(id);
    }

    @Override
    public List<Role> getAllRolesByDoctorId(long id) {
        return roleRepository.listOfRolesByDoctorId(id);
    }

    @Override
    public Role updateRole(long id, Role role) {
        Role roleFromDatabase = roleRepository.getOne(id);
        return null;
    }

    @Override
    public Role saveRole(Role role) {
        return null;
    }

    @Override
    public void deleteRoleById(long id) {

    }
}
