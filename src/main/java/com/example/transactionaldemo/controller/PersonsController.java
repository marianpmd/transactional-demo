package com.example.transactionaldemo.controller;

import com.example.transactionaldemo.DTO.PersonsDTO;
import com.example.transactionaldemo.service.PersonsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class PersonsController {
    private final PersonsService personsService;

    @GetMapping("/all")
    public ResponseEntity<List<PersonsDTO>> getAllPersons(){
        List<PersonsDTO> all = personsService.findAll();

        return ResponseEntity.ok(all);
    }

    @PutMapping("/update")
    public ResponseEntity<PersonsDTO> updateEntity(@RequestBody PersonsDTO personsDTO){
        PersonsDTO updated = personsService.update(personsDTO) ;

        return ResponseEntity.ok(updated);
    }

}
