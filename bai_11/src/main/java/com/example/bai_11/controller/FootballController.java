package com.example.bai_11.controller;

import com.example.bai_11.model.Football;
import com.example.bai_11.service.IFootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/player")
@CrossOrigin("*")
public class FootballController {
    @Autowired
    private IFootballService iFootballService;

    @GetMapping()
    public ResponseEntity<List<Football>> showListFootball(){
        List<Football>footballList =iFootballService.findAll();
        if (footballList.isEmpty()){
            return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(footballList, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Football> showDetailFootball(@PathVariable int id){
        Optional<Football> football = iFootballService.findById(id);

        return football.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping()
    public ResponseEntity<Football> createFootball(@RequestBody Football football){
        return new ResponseEntity<>(iFootballService.create(football),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Football> deleteFootball(@PathVariable Integer id){
        Optional<Football> football = iFootballService.findById(id);
        if (!football.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iFootballService.delete(id);
        return new ResponseEntity<>(football.get(), HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Football> updateFootball(@PathVariable Integer id, @RequestBody Football football){
        Optional<Football> football1 = iFootballService.findById(id);
        if (!football1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        football.setId(football1.get().getId());
        return new ResponseEntity<>(iFootballService.create(football), HttpStatus.OK);
    }
}
