package id.co.asyst.wfm.user.repository;

import id.co.asyst.wfm.core.repository.BaseJpaRepository;
import id.co.asyst.wfm.user.model.Function;
import org.springframework.stereotype.Repository;

@Repository
public interface FunctionRepository extends BaseJpaRepository<Function,Long>
{

}
