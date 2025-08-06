package com.askly.monu.askly.Repositories;

import org.springframework.core.metrics.StartupStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepo extends JpaRepository<StartupStep.Tags, Long> {


}
