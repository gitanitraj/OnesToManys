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

    private final MortgageProgramRepository repo;
    private final StateHousingSupportRepository stateRepo;

    public MortgageProgramService(MortgageProgramRepository repo,
                                  StateHousingSupportRepository stateRepo) {
        this.repo = repo;
        this.stateRepo = stateRepo;
    }

    // GET all mortgage programs
    public List<MortgageProgramListDTO> getAll() {
        return repo.findAll()
                .stream()
                .map(this::toListDTO)
                .collect(Collectors.toList());
    }

    // GET all mortgage programs for a specific state
    public List<MortgageProgramListDTO> getByState(Long stateId) {
        return repo.findAll()
                .stream()
                .filter(mp -> mp.getState().getId().equals(stateId))
                .map(this::toListDTO)
                .collect(Collectors.toList());
    }

    // GET one mortgage program by id
    public MortgageProgramDetailDTO getOne(Long id) {
        MortgageProgram mp = repo.findById(id).orElseThrow();
        return toDetailDTO(mp);
    }

    // CREATE a mortgage program
    public MortgageProgramDetailDTO create(Long stateId, MortgageProgramDetailDTO dto) {
        StateHousingSupport state = stateRepo.findById(stateId).orElseThrow();

        MortgageProgram mp = new MortgageProgram(
                dto.getProgramName(),
                dto.getDescription(),
                dto.getMaxLoan(),
                dto.getInterestRate(),
                state
        );

        MortgageProgram saved = repo.save(mp);
        return toDetailDTO(saved);
    }

    // UPDATE a mortgage program
    public MortgageProgramDetailDTO update(Long id, MortgageProgramDetailDTO dto) {
        MortgageProgram existing = repo.findById(id).orElseThrow();

        existing.setProgramName(dto.getProgramName());
        existing.setDescription(dto.getDescription());
        existing.setMaxLoan(dto.getMaxLoan());
        existing.setInterestRate(dto.getInterestRate());

        MortgageProgram saved = repo.save(existing);
        return toDetailDTO(saved);
    }

    // DELETE a mortgage program
    public void delete(Long id) {
        repo.deleteById(id);
    }

    // ----------------------
    // DTO MAPPERS
    // ----------------------

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
                mp.getState().getId(),
                mp.getProgramName(),
                mp.getDescription(),
                mp.getMaxLoan(),
                mp.getInterestRate()
        );
    }
}
