package com.hr.learning.projectbackend.srky.repository;

import com.hr.learning.projectbackend.srky.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Integer> {
}
