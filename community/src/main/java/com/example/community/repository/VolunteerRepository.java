package com.example.community.repository;

import com.example.community.entity.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {

    List<Volunteer> findVolunteerByAppliedJobs(Pageable pageable);

}

