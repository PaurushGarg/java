package com.example.community.service;

import com.example.community.entity.Volunteer;
import com.example.community.model.VolunteerDto;
import com.example.community.repository.VolunteerRepository;
import com.example.community.response.VolunteerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VolunteerServiceImpl implements VolunteerService{

    private VolunteerRepository volunteerRepository;

    public VolunteerServiceImpl(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }

    @Override
    public VolunteerResponse getAllVolunteerByJobId(int pageNo, int pageSize, String sortBy, String sortDir, String jobId) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Volunteer> volunteerPage = volunteerRepository.findAll(pageable);

        List<Volunteer> volunteers = volunteerPage.getContent();

        List<VolunteerDto> content= volunteers.stream().map(volunteer -> mapToDTO(volunteer)).collect(Collectors.toList());

        VolunteerResponse volunteerResponse = new VolunteerResponse();
        volunteerResponse.setContent(content);
        volunteerResponse.setPageNo(volunteerPage.getNumber());
        volunteerResponse.setPageSize(volunteerPage.getSize());
        volunteerResponse.setTotalElements(volunteerPage.getTotalElements());
        volunteerResponse.setTotalPages(volunteerPage.getTotalPages());
        volunteerResponse.setLast(volunteerPage.isLast());

        return volunteerResponse;
    }

    private VolunteerDto mapToDTO(Volunteer volunteer){
        VolunteerDto volunteerDto = new VolunteerDto();
        volunteerDto.setId(volunteer.getId());
        volunteerDto.setFirstName(volunteer.getFirstName());
        volunteerDto.setLastName(volunteer.getLastName());
        return volunteerDto;
    }

}
