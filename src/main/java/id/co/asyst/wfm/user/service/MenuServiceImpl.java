package id.co.asyst.wfm.user.service;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.user.model.Menu;
import id.co.asyst.wfm.user.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MenuServiceImpl extends BaseServiceManager<Menu,Long> implements MenuService<Menu,Long>
{

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Collection<Menu> findAll() {
        return (Collection<Menu>) menuRepository.findAll();
    }

    @Override
    public Menu findById(Long aLong) {
        return menuRepository.findById(aLong).get();
    }

    @Override
    public Menu saveOrUpdate(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public void deleteById(Long aLong) {
        menuRepository.deleteById(aLong);
    }

    @Override
    public void delete(Menu menu) {
        menuRepository.delete(menu);
    }
}
