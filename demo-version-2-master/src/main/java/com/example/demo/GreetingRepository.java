package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long> {
    @Query(value = "SELECT surname from actors where soundex(surname) = soundex(?1);", nativeQuery = true)
    ArrayList<String> findContent(String cont);
}
