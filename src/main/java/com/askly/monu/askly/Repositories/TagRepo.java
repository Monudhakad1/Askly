package com.askly.monu.askly.Repositories;

import org.springframework.core.metrics.StartupStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepo extends JpaRepository<StartupStep.Tags, Long> {
}
