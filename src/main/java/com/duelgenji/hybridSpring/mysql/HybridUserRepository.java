package com.duelgenji.hybridSpring.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface HybridUserRepository extends JpaRepository<HybridUser, Long>{
}
