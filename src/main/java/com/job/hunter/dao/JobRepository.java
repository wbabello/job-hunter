package com.job.hunter.dao;

import com.job.hunter.model.Advertiser;
import com.job.hunter.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

    List<Job> findByAdvertiserAndStatusNotIn(Advertiser advertiser, Collection<String> status);

    List<Job> findByStatusNotIn(Collection<String> status);

    @Query("from Job WHERE (title = ?1 or location = ?2) and status <> 'Completed'")
    List<Job> findByTitleContainingIgnoreCaseOrLocationContainingIgnoreCaseAndStatusNotIn(String title, String location);
}
