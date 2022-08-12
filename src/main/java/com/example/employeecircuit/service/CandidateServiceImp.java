package com.example.employeecircuit.service;

import com.example.employeecircuit.model.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateServiceImp implements CandidateService {

    @Autowired
    RestTemplate template;

    @Autowired
    CircuitBreakerFactory factory;

    private String url = "http://localhost:420/myservice/";
    private String context = "ms-employee/employees";

    @Override
    public List<Candidate> CandidateJob(String job) {
        CircuitBreaker circuitBreaker = factory.create("circuit1");
        return circuitBreaker.run(() -> {
                    List<Candidate> candidates = Arrays.asList(template.getForObject(url + context, Candidate[].class));
                    return candidates.stream()
                            .filter(candidate -> candidate.getLvl().equals(job))
                            .collect(Collectors.toList());

                },
                t -> new ArrayList<Candidate>());
    }
}
