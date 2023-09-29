package com.example.community.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "jobs", uniqueConstraints = {@UniqueConstraint(columnNames = {"job_id"})}
)
public class Job {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long jobId;

    @Column(name = "job_name", nullable = false)
    private String jobName;

    @Column(name = "job_des", nullable = false)
    private String jobDes;

    @ManyToMany(mappedBy = "appliedJobs")
    List<Volunteer> volunteersAppliedThisJob;
}
