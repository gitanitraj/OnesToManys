package com.example.listdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.listdetails.model.MortgageProgram;
import com.example.listdetails.model.StateHousingSupport;
import com.example.listdetails.repository.MortgageProgramRepository;
import com.example.listdetails.repository.StateHousingSupportRepository;
 
@RestController
@RequestMapping("/programs")
public class MortgageProgramController {
 
    @Autowired
    private MortgageProgramRepository programRepo;
 
    @Autowired
    private StateHousingSupportRepository stateRepo;
 
    // GET all mortgage programs
    // curl http://localhost:8080/programs
    @GetMapping
    public List<MortgageProgram> getAll() {
        return programRepo.findAll();
    }
 
    // GET one mortgage program by id
    // curl http://localhost:8080/programs/1
    @GetMapping("/{id}")
    public MortgageProgram getOne(@PathVariable Long id) {
        return programRepo.findById(id).orElseThrow();
    }
 
    // POST - add a new mortgage program
    // curl -X POST http://localhost:8080/programs \
    //   -H "Content-Type: application/json" \
    //   -d '{"programName":"New Program","description":"Details here","maxLoan":400000,"interestRate":6.25,"state":{"id":1}}'
    @PostMapping
    public MortgageProgram create(@RequestBody MortgageProgram program) {
        StateHousingSupport state = stateRepo
            .findById(program.getState().getId())
            .orElseThrow();
        program.setState(state);
        return programRepo.save(program);
    }
 
    // PUT - update an existing mortgage program
    // curl -X PUT http://localhost:8080/programs/1 \
    //   -H "Content-Type: application/json" \
    //   -d '{"programName":"Updated Name","description":"New details","maxLoan":500000,"interestRate":6.10,"state":{"id":1}}'
    @PutMapping("/{id}")
    public MortgageProgram update(@PathVariable Long id, @RequestBody MortgageProgram updated) {
        MortgageProgram existing = programRepo.findById(id).orElseThrow();
        existing.setProgramName(updated.getProgramName());
        existing.setDescription(updated.getDescription());
        existing.setMaxLoan(updated.getMaxLoan());
        existing.setInterestRate(updated.getInterestRate());
 
        StateHousingSupport state = stateRepo
            .findById(updated.getState().getId())
            .orElseThrow();
        existing.setState(state);
 
        return programRepo.save(existing);
    }
 
    // DELETE - remove a mortgage program
    // curl -X DELETE http://localhost:8080/programs/1
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        programRepo.deleteById(id);
        return "Mortgage program " + id + " deleted.";
    }
}
