package com.example.listdetails.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.listdetails.dto.MortgageProgramDetailDTO;
import com.example.listdetails.dto.MortgageProgramListDTO;
import com.example.listdetails.dto.StateHousingSupportDetailDTO;
import com.example.listdetails.dto.StateHousingSupportListDTO;
import com.example.listdetails.model.MortgageProgram;
import com.example.listdetails.model.StateHousingSupport;
import com.example.listdetails.repository.MortgageProgramRepository;
import com.example.listdetails.repository.StateHousingSupportRepository;

@Service
public class StateHousingSupportService {

    private final StateHousingSupportRepository stateRepository;
    private final MortgageProgramRepository mortgageProgramRepository;

    public StateHousingSupportService(StateHousingSupportRepository stateRepository,
                                      MortgageProgramRepository mortgageProgramRepository) {
        this.stateRepository = stateRepository;
        this.mortgageProgramRepository = mortgageProgramRepository;
    }

    // -------------------------
    // MASTER CRUD
    // -------------------------

    public List<StateHousingSupportListDTO> getAll() {
        return stateRepository.findAll()
                .stream()
                .map(this::toListDTO)
                .collect(Collectors.toList());
    }

    public StateHousingSupportDetailDTO getById(Long id) {
        StateHousingSupport state = stateRepository.findById(id).orElseThrow();
        return toDetailDTO(state);
    }

    public StateHousingSupportDetailDTO create(StateHousingSupport state) {
        StateHousingSupport saved = stateRepository.save(state);
        return toDetailDTO(saved);
    }

    public StateHousingSupportDetailDTO update(Long id, StateHousingSupport updated) {
        StateHousingSupport existing = stateRepository.findById(id).orElseThrow();

        existing.setStateName(updated.getStateName());
        existing.setAgencyName(updated.getAgencyName());
        existing.setWebsite(updated.getWebsite());
        existing.setPhone(updated.getPhone());

        StateHousingSupport saved = stateRepository.save(existing);
        return toDetailDTO(saved);
    }

    public void delete(Long id) {
        stateRepository.deleteById(id);
    }

    // -------------------------
    // DTO MAPPERS
    // -------------------------

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

    private MortgageProgramListDTO toProgramListDTO(MortgageProgram mp) {
        return new MortgageProgramListDTO(
                mp.getId(),
                mp.getProgramName(),
                mp.getDescription(),
                mp.getInterestRate(),
                mp.getMaxLoanAmount(),
                mp.getTermYears(),
                mp.getActive(),
                mp.getStateHousingSupport().getId(),
                mp.getStateHousingSupport().getStateName()
        );
    }

    private MortgageProgramDetailDTO toProgramDetailDTO(MortgageProgram mp) {
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

    // -------------------------
    // ONE-TO-MANY METHODS (NO PAGINATION YET)
    // -------------------------

    public List<MortgageProgramListDTO> getProgramsByState(Long stateId) {
        return mortgageProgramRepository.findByStateHousingSupportId(stateId)
                .stream()
                .map(this::toProgramListDTO)
                .collect(Collectors.toList());
    }

    public MortgageProgramDetailDTO createProgram(Long stateId, MortgageProgramDetailDTO dto) {
        StateHousingSupport state = stateRepository.findById(stateId)
                .orElseThrow(() -> new RuntimeException("State not found"));

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

        return toProgramDetailDTO(mortgageProgramRepository.save(mp));
    }

    public MortgageProgramDetailDTO updateProgram(Long stateId, Long programId, MortgageProgramDetailDTO dto) {
        MortgageProgram existing = mortgageProgramRepository.findById(programId)
                .orElseThrow(() -> new RuntimeException("Program not found"));

        if (!existing.getStateHousingSupport().getId().equals(stateId)) {
            throw new RuntimeException("Program does not belong to this state");
        }

        existing.setProgramName(dto.getProgramName());
        existing.setDescription(dto.getDescription());
        existing.setInterestRate(dto.getInterestRate());
        existing.setMaxLoanAmount(dto.getMaxLoanAmount());
        existing.setTermYears(dto.getTermYears());
        existing.setActive(dto.getActive());

        return toProgramDetailDTO(mortgageProgramRepository.save(existing));
    }

    public void deleteProgram(Long stateId, Long programId) {
        MortgageProgram existing = mortgageProgramRepository.findById(programId)
                .orElseThrow(() -> new RuntimeException("Program not found"));

        if (!existing.getStateHousingSupport().getId().equals(stateId)) {
            throw new RuntimeException("Program does not belong to this state");
        }

        mortgageProgramRepository.delete(existing);
    }
}
