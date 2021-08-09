package com.example.transactionaldemo.repository;

import com.example.transactionaldemo.entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<RolesEntity , Long> {
}
