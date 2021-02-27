package id.co.asyst.wfm.user.service;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.user.model.Role;
import id.co.asyst.wfm.user.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RoleServiceImpl extends BaseServiceManager<Role,String> implements RoleService<Role,String>
{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Collection<Role> findAll() {
        return (Collection<Role>) roleRepository.findAll();
    }

    @Override
    public Role findById(String code) {
        return roleRepository.findById(code).get();
    }

    @Override
    public Role saveOrUpdate(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteById(String code) {
        roleRepository.deleteById(code);
    }

    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }
}
