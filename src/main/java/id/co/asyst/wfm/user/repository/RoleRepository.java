package id.co.asyst.wfm.user.repository;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.user.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends BaseJpaRepository<Role, String>
{


}
