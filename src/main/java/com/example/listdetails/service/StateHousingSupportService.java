package com.example.listdetails.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.listdetails.dto.StateHousingSupportDetailDTO;
import com.example.listdetails.dto.StateHousingSupportListDTO;
import com.example.listdetails.model.StateHousingSupport;
import com.example.listdetails.repository.StateHousingSupportRepository;

@Service
public class StateHousingSupportService {

    private final StateHousingSupportRepository repository;

    public StateHousingSupportService(StateHousingSupportRepository repository) {
        this.repository = repository;
    }

    public List<StateHousingSupportListDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::toListDTO)
                .collect(Collectors.toList());
    }

    private StateHousingSupportListDTO toListDTO(StateHousingSupport entity) {
    return new StateHousingSupportListDTO(
        entity.getId(),
        entity.getStateName(),
        entity.getAgencyName()
    );
    }

public StateHousingSupportDetailDTO getById(Long id) {
    StateHousingSupport s = repository.findById(id).orElseThrow();
    return new StateHousingSupportDetailDTO(
        s.getId(),
        s.getStateName(),
        s.getAgencyName(),
        s.getWebsite(),
        s.getPhone());
}

public StateHousingSupport save(StateHousingSupport state) {
    return repository.save(state);
}

public void delete(Long id) {
    repository.deleteById(id);
}
}
