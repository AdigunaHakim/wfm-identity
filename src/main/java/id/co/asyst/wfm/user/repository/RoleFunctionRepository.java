package id.co.asyst.wfm.user.repository;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.user.model.RoleFunction;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleFunctionRepository extends BaseJpaRepository<RoleFunction,Long>
{


}
