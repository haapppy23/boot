package com.mysite.sbb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuetionRepository extends JpaRepository<Question, Integer> {
}
