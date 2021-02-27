package id.co.asyst.wfm.user.repository;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.user.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseJpaRepository<User,String>
{
    User findByUsernameAndPassword(String username, String password);
    User findByEmployeeIdAndPassword(String id, String password);
}
