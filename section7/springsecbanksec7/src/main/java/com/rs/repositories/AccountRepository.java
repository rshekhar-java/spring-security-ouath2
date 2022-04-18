package com.rs.repositories;

import com.rs.model.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * created by rs 4/12/2022.
 */
@Repository
public interface AccountRepository extends CrudRepository<Accounts,Long> {

    Accounts findByCustomerId(int customerId);

}
