package com.techbow.datadashboard.model.dao.repository;

import com.techbow.datadashboard.model.dvo.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataJpaRepository extends JpaRepository<Data, Long> {
    List<Data> findByClientId(Long clientId);

    @Query(value = "SELECT * FROM data LIMIT :limit", nativeQuery = true)
    List<Data> findAllByLimit(@Param("limit") Integer limit);

    List<Data> findByClientIdOrderByStepCount(Long clientId);
    List<Data> findByHeartBeatBetween(Integer start, Integer end);
}
