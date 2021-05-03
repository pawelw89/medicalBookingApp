package repository;

import entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository <Role, Long> {

    List<Role> listOfRolesByUserId (long id);

    List<Role> listOfRolesByDoctorId (long id);
}
