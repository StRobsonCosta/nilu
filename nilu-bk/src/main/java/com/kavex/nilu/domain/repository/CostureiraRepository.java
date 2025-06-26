package com.kavex.nilu.domain.repository;

import com.kavex.nilu.domain.model.Costureira;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CostureiraRepository extends JpaRepository<Costureira, UUID> {
}
