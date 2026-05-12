package com.example.listdetails.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

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

}
