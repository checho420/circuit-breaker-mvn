package com.example.employeecircuit.controller;

import com.example.employeecircuit.model.Candidate;
import com.example.employeecircuit.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CandidateController {

    @Autowired
    CandidateService candidateService;

    @GetMapping(value = "ms-candidate/{job}")
    public List<Candidate> candidateJob(@PathVariable String job) {
        return candidateService.CandidateJob(job);
    }
}
