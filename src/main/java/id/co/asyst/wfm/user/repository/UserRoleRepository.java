package id.co.asyst.wfm.user.repository;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.user.model.User;
import id.co.asyst.wfm.user.model.UserRole;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends BaseJpaRepository<UserRole,Long>
{
    UserRole findByUser(User users);
}
