package com.job.hunter.dao;

import com.job.hunter.model.Advertiser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertiserRepository extends JpaRepository<Advertiser, Integer> {

    Advertiser findByEmail(String email);
}
