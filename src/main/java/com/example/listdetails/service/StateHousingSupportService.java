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

    public StateHousingSupportDetailDTO getById(Long id) {
        StateHousingSupport state = repository.findById(id).orElseThrow();
        return toDetailDTO(state);
    }

    public StateHousingSupportDetailDTO create(StateHousingSupport state) {
        StateHousingSupport saved = repository.save(state);
        return toDetailDTO(saved);
    }

    public StateHousingSupportDetailDTO update(Long id, StateHousingSupport updated) {
        StateHousingSupport existing = repository.findById(id).orElseThrow();

        existing.setStateName(updated.getStateName());
        existing.setAgencyName(updated.getAgencyName());
        existing.setWebsite(updated.getWebsite());
        existing.setPhone(updated.getPhone());

        StateHousingSupport saved = repository.save(existing);
        return toDetailDTO(saved);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private StateHousingSupportListDTO toListDTO(StateHousingSupport s) {
        return new StateHousingSupportListDTO(
                s.getId(),
                s.getStateName(),
                s.getAgencyName()
        );
    }

    private StateHousingSupportDetailDTO toDetailDTO(StateHousingSupport s) {
        return new StateHousingSupportDetailDTO(
                s.getId(),
                s.getStateName(),
                s.getAgencyName(),
                s.getWebsite(),
                s.getPhone()
        );
    }
}
