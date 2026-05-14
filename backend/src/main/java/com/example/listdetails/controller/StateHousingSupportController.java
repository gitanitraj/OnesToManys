package com.example.listdetails.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.listdetails.dto.MortgageProgramDetailDTO;
import com.example.listdetails.dto.MortgageProgramListDTO;
import com.example.listdetails.dto.StateHousingSupportDetailDTO;
import com.example.listdetails.dto.StateHousingSupportListDTO;
import com.example.listdetails.model.StateHousingSupport;
import com.example.listdetails.service.StateHousingSupportService;

@RestController
@RequestMapping("/api/states")
@CrossOrigin(origins = "*")
public class StateHousingSupportController {

    private final StateHousingSupportService service;

    public StateHousingSupportController(StateHousingSupportService service) {
        this.service = service;
    }

    // -------------------------
    // MASTER CRUD ENDPOINTS
    // -------------------------

    @GetMapping
    public List<StateHousingSupportListDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public StateHousingSupportDetailDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public StateHousingSupportDetailDTO create(@RequestBody StateHousingSupport state) {
        return service.create(state);
    }

    @PutMapping("/{id}")
    public StateHousingSupportDetailDTO update(
            @PathVariable Long id,
            @RequestBody StateHousingSupport updated
    ) {
        return service.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    // -------------------------
    // ONE-TO-MANY ENDPOINTS
    // -------------------------

    @GetMapping("/{stateId}/programs")
    public List<MortgageProgramListDTO> getProgramsByState(
        @PathVariable Long stateId
    ) {
        return service.getProgramsByState(stateId);
    }

    @PostMapping("/{stateId}/programs")
    public MortgageProgramDetailDTO createProgram(
        @PathVariable Long stateId,
        @RequestBody MortgageProgramDetailDTO dto
    ) {
        return service.createProgram(stateId, dto);
    }

    @PutMapping("/{stateId}/programs/{programId}")
    public MortgageProgramDetailDTO updateProgram(
        @PathVariable Long stateId,
        @PathVariable Long programId,
        @RequestBody MortgageProgramDetailDTO dto
    ) {
    return service.updateProgram(stateId, programId, dto);
    }

    @DeleteMapping("/{stateId}/programs/{programId}")
    public void deleteProgram(
        @PathVariable Long stateId,
        @PathVariable Long programId
    ) {
    service.deleteProgram(stateId, programId);
    }

}

