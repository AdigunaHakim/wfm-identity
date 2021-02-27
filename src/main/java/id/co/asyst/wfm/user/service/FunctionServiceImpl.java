package id.co.asyst.wfm.user.service;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.user.model.Function;
import id.co.asyst.wfm.user.repository.FunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FunctionServiceImpl extends BaseServiceManager<Function,Long> implements FunctionService<Function,Long>
{

    @Autowired
    private FunctionRepository functionRepository;

    @Override
    public Collection<Function> findAll() {
        return (Collection<Function>) functionRepository.findAll();
    }

    @Override
    public Function findById(Long aLong) {
        return functionRepository.findById(aLong).get();
    }

    @Override
    public Function saveOrUpdate(Function function) {
        return functionRepository.save(function);
    }

    @Override
    public void deleteById(Long aLong) {
        functionRepository.deleteById(aLong);
    }

    @Override
    public void delete(Function function) {
        functionRepository.delete(function);
    }
}
