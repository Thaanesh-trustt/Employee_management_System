package employeemanagement.com.employees.Service;

import employeemanagement.com.employees.DAO.RoleRepository;
import employeemanagement.com.employees.Model.Role;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public Role save(Role theRole) {
        return roleRepository.save(theRole);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(int role_id) {
        Optional<Role> result = roleRepository.findById(role_id);
        Role theRole = null;
        if (result.isPresent()) {
            theRole = result.get();
        } else {
            throw new EntityNotFoundException("Role_id not found" + role_id);
        }
        return theRole;
    }

    public Role update(int id, Role updatedRole) {
        Optional<Role> existingRoleOptional = roleRepository.findById(id);
        if (!existingRoleOptional.isPresent()) {
            throw new EntityNotFoundException("Role not found for id: " + id);
        }
        Role existingRole = existingRoleOptional.get();
        existingRole.setRole_name(updatedRole.getRole_name());
        return roleRepository.save(existingRole);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        roleRepository.deleteById(theId);
    }

    @Override
    @Transactional
    public Role findByRole(String role) {
        return roleRepository.findByRoleName(role);
    }
}
