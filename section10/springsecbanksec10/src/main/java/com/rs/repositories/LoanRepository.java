package com.rs.repositories;

import com.rs.model.Loans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by rs 4/12/2022.
 */
@Repository
public interface LoanRepository extends CrudRepository<Loans,Long> {

    @PreAuthorize("hasRole('ROOT')")
    List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);
}
