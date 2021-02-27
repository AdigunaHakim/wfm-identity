package id.co.asyst.wfm.user.repository;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.user.model.RoleMenu;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMenuRepository extends BaseJpaRepository<RoleMenu,Long>
{


}
