package com.rs.repositories;

import com.rs.model.Cards;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by rs 4/12/2022.
 */
@Repository
public interface CardsRepository extends CrudRepository<Cards,Long> {

    List<Cards> findByCustomerId(int customerId);
}
