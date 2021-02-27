package id.co.asyst.wfm.user.repository;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.user.model.Menu;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends BaseJpaRepository<Menu,Long>
{


}
