package id.co.asyst.wfm.user.service;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.user.model.RoleMenu;
import id.co.asyst.wfm.user.repository.RoleMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RoleMenuServiceImpl extends BaseServiceManager<RoleMenu,Long> implements RoleMenuService<RoleMenu,Long>
{

    @Autowired
    private RoleMenuRepository roleMenuRepository;

    @Override
    public Collection<RoleMenu> findAll() {
        return (Collection<RoleMenu>) roleMenuRepository.findAll();
    }

    @Override
    public RoleMenu findById(Long aLong) {
        return roleMenuRepository.findById(aLong).get();
    }

    @Override
    public RoleMenu saveOrUpdate(RoleMenu roleMenu) {
        return roleMenuRepository.save(roleMenu);
    }

    @Override
    public void deleteById(Long aLong) {
        roleMenuRepository.deleteById(aLong);
    }

    @Override
    public void delete(RoleMenu roleMenu) {
        roleMenuRepository.delete(roleMenu);
    }
}
