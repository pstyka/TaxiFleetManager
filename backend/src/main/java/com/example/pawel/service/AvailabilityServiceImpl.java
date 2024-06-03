package com.example.pawel.service;

import com.example.pawel.entities.Availability;
import com.example.pawel.mappers.AvailabilityMapper;
import com.example.pawel.model.AvailabilityDTO;
import com.example.pawel.repository.AvailabilityRepository;
import com.example.pawel.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvailabilityServiceImpl implements AvailabilityService {

    private final AvailabilityRepository availabilityRepository;
    private final AvailabilityMapper availabilityMapper;
    private final UserRepository userRepository;

    @Override
    public List<AvailabilityDTO> getAvailability() {
        return availabilityRepository.findAll()
                .stream()
                .map(availabilityMapper::availabilityToAvailabilityDTO)
                .toList();
    }

    @Override
    @Transactional
    public AvailabilityDTO saveNewAvailability(AvailabilityDTO availabilityDTO) {
        Availability availability = availabilityMapper.availabilityDTOToAvailability(availabilityDTO);
        Availability savedAvailability = availabilityRepository.save(availability);
        return availabilityMapper.availabilityToAvailabilityDTO(savedAvailability);
    }
}
