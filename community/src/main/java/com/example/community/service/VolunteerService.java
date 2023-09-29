package com.example.community.service;

import com.example.community.response.VolunteerResponse;

public interface VolunteerService {

//    VolunteerResponse getAllVolunteer(int pageNo, int pageSize, String sortBy, String sortDir);
    VolunteerResponse getAllVolunteerByJobId(int pageNo, int pageSize, String sortBy, String sortDir, String jobId);

}
