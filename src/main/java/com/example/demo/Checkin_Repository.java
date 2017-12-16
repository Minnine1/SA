package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface Checkin_Repository extends CrudRepository<Checkin,Long> {
    // Checkin findByRecord(
    //         @Param("record") String record
    // );
}
