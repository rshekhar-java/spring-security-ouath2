package com.rs.repositories;

import com.rs.model.Notice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by rs 4/12/2022.
 */
@Repository
public interface NoticeRepository extends CrudRepository<Notice,Long> {

//    @Modifying
    @Query(value = "from Notice where CURRENT_DATE BETWEEN noticeBegDt AND noticeEndDt")
//    @Query(value = "from Notice n")
    List<Notice> findAllActiveNotices();
}
