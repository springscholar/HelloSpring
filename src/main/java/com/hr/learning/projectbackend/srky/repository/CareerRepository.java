package com.hr.learning.projectbackend.srky.repository;

import com.hr.learning.projectbackend.srky.entity.CareerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareerRepository extends JpaRepository<CareerEntity, Integer> {
}
