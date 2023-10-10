package com.job.hunter.dao;

import com.job.hunter.model.AppliedJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppliedJobRepository extends JpaRepository<AppliedJob, Integer> {
}
