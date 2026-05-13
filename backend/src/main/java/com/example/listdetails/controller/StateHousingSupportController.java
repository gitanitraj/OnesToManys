package com.example.listdetails.controller;

import com.example.listdetails.dto.StateHousingSupportDetailDTO;
import com.example.listdetails.dto.StateHousingSupportListDTO;
import com.example.listdetails.model.StateHousingSupport;
import com.example.listdetails.service.StateHousingSupportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/states")
@CrossOrigin(origins = "*")
public class StateHousingSupportController {

    private final StateHousingSupportService service;

    public StateHousingSupportController(StateHousingSupportService service) {
        this.service = service;
    }

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
    public StateHousingSupportDetailDTO update(@PathVariable Long id,
                                               @RequestBody StateHousingSupport updated) {
        return service.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
