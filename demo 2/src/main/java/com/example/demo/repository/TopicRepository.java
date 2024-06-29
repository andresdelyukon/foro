package com.example.demo.repository;

import com.example.demo.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topico, Long> {
}
