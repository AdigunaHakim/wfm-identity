package id.co.asyst.wfm.user.service;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.user.model.RoleFunction;
import id.co.asyst.wfm.user.repository.RoleFunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RoleFunctionServiceImpl extends BaseServiceManager<RoleFunction,Long> implements RoleFunctionService<RoleFunction,Long>
{

    @Autowired
    private RoleFunctionRepository roleFunctionRepository;

    @Override
    public Collection<RoleFunction> findAll() {
        return (Collection<RoleFunction>) roleFunctionRepository.findAll();
    }

    @Override
    public RoleFunction findById(Long aLong) {
        return roleFunctionRepository.findById(aLong).get();
    }

    @Override
    public RoleFunction saveOrUpdate(RoleFunction roleFunction) {
        return roleFunctionRepository.save(roleFunction);
    }

    @Override
    public void deleteById(Long aLong) {
        roleFunctionRepository.deleteById(aLong);
    }

    @Override
    public void delete(RoleFunction roleFunction) {
        roleFunctionRepository.delete(roleFunction);
    }
}
