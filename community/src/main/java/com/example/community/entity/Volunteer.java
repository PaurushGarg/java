package com.example.community.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "volunteers", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})}
)
public class Volunteer {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;

    @Column(name = "first_name", nullable = false)

    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "jobs_volunteer",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "job_id"))
    List<Job> appliedJobs;
}
