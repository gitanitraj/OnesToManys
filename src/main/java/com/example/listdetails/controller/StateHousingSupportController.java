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

import com.example.listdetails.model.StateHousingSupport;
import com.example.listdetails.repository.StateHousingSupportRepository;
 
@RestController
@RequestMapping("/states")
public class StateHousingSupportController {
 
    @Autowired
    private StateHousingSupportRepository repo;
 
    // GET all states
    // curl http://localhost:8080/states
    @GetMapping
    public List<StateHousingSupport> getAll() {
        return repo.findAll();
    }
 
    // GET one state by id
    // curl http://localhost:8080/states/1
    @GetMapping("/{id}")
    public StateHousingSupport getOne(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }
 
    // POST - add a new state housing agency
    // curl -X POST http://localhost:8080/states \
    //   -H "Content-Type: application/json" \
    //   -d '{"stateName":"Virginia","agencyName":"VHDA","website":"https://www.vhda.com","phone":"800-968-7837"}'
    @PostMapping
    public StateHousingSupport create(@RequestBody StateHousingSupport state) {
        return repo.save(state);
    }
 
    // PUT - update an existing state housing agency
    // curl -X PUT http://localhost:8080/states/1 \
    //   -H "Content-Type: application/json" \
    //   -d '{"stateName":"Pennsylvania","agencyName":"PHFA Updated","website":"https://www.phfa.org","phone":"1-855-827-3466"}'
    @PutMapping("/{id}")
    public StateHousingSupport update(@PathVariable Long id, @RequestBody StateHousingSupport updated) {
        StateHousingSupport existing = repo.findById(id).orElseThrow();
        existing.setStateName(updated.getStateName());
        existing.setAgencyName(updated.getAgencyName());
        existing.setWebsite(updated.getWebsite());
        existing.setPhone(updated.getPhone());
        return repo.save(existing);
    }
 
    // DELETE - remove a state housing agency
    // curl -X DELETE http://localhost:8080/states/1
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "State housing agency " + id + " deleted.";
    }
}
