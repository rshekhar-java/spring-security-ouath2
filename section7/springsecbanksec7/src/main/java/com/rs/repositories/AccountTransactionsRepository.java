package com.rs.repositories;

import com.rs.model.AccountTransactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by rs 4/12/2022.
 */
@Repository
public interface AccountTransactionsRepository extends CrudRepository<AccountTransactions,Long> {

    List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(int customerId);

}
