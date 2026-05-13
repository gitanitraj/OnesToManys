package com.example.listdetails.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.listdetails.dto.MortgageProgramDetailDTO;
import com.example.listdetails.dto.MortgageProgramListDTO;
import com.example.listdetails.model.MortgageProgram;
import com.example.listdetails.model.StateHousingSupport;
import com.example.listdetails.repository.MortgageProgramRepository;
import com.example.listdetails.repository.StateHousingSupportRepository;

@Service
public class MortgageProgramService {

    private final MortgageProgramRepository repository;
    private final StateHousingSupportRepository stateRepository;

    public MortgageProgramService(MortgageProgramRepository repository,
                                  StateHousingSupportRepository stateRepository) {
        this.repository = repository;
        this.stateRepository = stateRepository;
    }

    public List<MortgageProgramListDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::toListDTO)
                .collect(Collectors.toList());
    }

    public List<MortgageProgramListDTO> getByState(Long stateId) {
        return repository.findByStateHousingSupportId(stateId)
                .stream()
                .map(this::toListDTO)
                .collect(Collectors.toList());
    }

    public MortgageProgramDetailDTO getOne(Long id) {
        MortgageProgram mp = repository.findById(id).orElseThrow();
        return toDetailDTO(mp);
    }

    public MortgageProgramDetailDTO create(Long stateId, MortgageProgramDetailDTO dto) {
        StateHousingSupport state = stateRepository.findById(stateId).orElseThrow();

        MortgageProgram mp = new MortgageProgram(
                null,
                state,
                dto.getProgramName(),
                dto.getDescription(),
                dto.getInterestRate(),
                dto.getMaxLoanAmount(),
                dto.getTermYears(),
                dto.getActive()
        );

        MortgageProgram saved = repository.save(mp);
        return toDetailDTO(saved);
    }

    public MortgageProgramDetailDTO update(Long id, MortgageProgramDetailDTO dto) {
        MortgageProgram existing = repository.findById(id).orElseThrow();

        existing.setProgramName(dto.getProgramName());
        existing.setDescription(dto.getDescription());
        existing.setInterestRate(dto.getInterestRate());
        existing.setMaxLoanAmount(dto.getMaxLoanAmount());
        existing.setTermYears(dto.getTermYears());
        existing.setActive(dto.getActive());

        MortgageProgram saved = repository.save(existing);
        return toDetailDTO(saved);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private MortgageProgramListDTO toListDTO(MortgageProgram mp) {
        return new MortgageProgramListDTO(
                mp.getId(),
                mp.getProgramName(),
                mp.getInterestRate()
        );
    }

    private MortgageProgramDetailDTO toDetailDTO(MortgageProgram mp) {
        return new MortgageProgramDetailDTO(
                mp.getId(),
                mp.getStateHousingSupport().getId(),
                mp.getStateHousingSupport().getStateName(),
                mp.getProgramName(),
                mp.getDescription(),
                mp.getInterestRate(),
                mp.getMaxLoanAmount(),
                mp.getTermYears(),
                mp.getActive()
        );
    }
}
