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
import com.example.listdetails.service.MortgageProgramService;

@RestController
@RequestMapping("/api/mortgage-programs")
@CrossOrigin(origins = "*")
public class MortgageProgramController {

    private final MortgageProgramService service;

    public MortgageProgramController(MortgageProgramService service) {
        this.service = service;
    }

    // ---------------------------------------------------------
    // GET all mortgage programs
    // ---------------------------------------------------------
    @GetMapping
    public List<MortgageProgramListDTO> getAll() {
        return service.getAll();
    }

    // ---------------------------------------------------------
    // GET mortgage programs by state
    // Example: /api/mortgage-programs/state/1
    // ---------------------------------------------------------
    @GetMapping("/state/{stateId}")
    public List<MortgageProgramListDTO> getByState(@PathVariable Long stateId) {
        return service.getByState(stateId);
    }

    // ---------------------------------------------------------
    // GET a single mortgage program by ID
    // ---------------------------------------------------------
    @GetMapping("/{id}")
    public MortgageProgramDetailDTO getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    // ---------------------------------------------------------
    // CREATE a mortgage program under a specific state
    // Example: POST /api/mortgage-programs/state/1
    // ---------------------------------------------------------
    @PostMapping("/state/{stateId}")
    public MortgageProgramDetailDTO create(@PathVariable Long stateId,
                                           @RequestBody MortgageProgramDetailDTO dto) {
        return service.create(stateId, dto);
    }

    // ---------------------------------------------------------
    // UPDATE a mortgage program
    // ---------------------------------------------------------
    @PutMapping("/{id}")
    public MortgageProgramDetailDTO update(@PathVariable Long id,
                                           @RequestBody MortgageProgramDetailDTO dto) {
        return service.update(id, dto);
    }

    // ---------------------------------------------------------
    // DELETE a mortgage program
    // ---------------------------------------------------------
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
