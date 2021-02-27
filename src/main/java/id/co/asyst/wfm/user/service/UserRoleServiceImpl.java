package id.co.asyst.wfm.user.service;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.user.model.UserRole;
import id.co.asyst.wfm.user.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserRoleServiceImpl extends BaseServiceManager<UserRole,Long> implements UserRoleService<UserRole,Long>
{

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public Collection<UserRole> findAll() {
        return (Collection<UserRole>) userRoleRepository.findAll();
    }

    @Override
    public UserRole findById(Long id) {
        return userRoleRepository.findById(id).get();
    }

    @Override
    public UserRole saveOrUpdate(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public void deleteById(Long id) {
        userRoleRepository.deleteById(id);
    }

    @Override
    public void delete(UserRole userRole) {
        userRoleRepository.delete(userRole);
    }
}
