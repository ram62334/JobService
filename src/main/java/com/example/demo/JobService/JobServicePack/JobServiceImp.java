package com.example.demo.JobService.JobServicePack;

import com.example.demo.JobService.Job;
import com.example.demo.JobService.JobRepository;
import com.example.demo.JobService.JobService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImp implements JobService {
//    private List<Job> l = new ArrayList<>();
    @Autowired
    JobRepository jr;
    @Override
    @CircuitBreaker(name="companyBreaker")
    public List<Job> findAll() {
        return jr.findAll();
    }

    @Override
    public void add(Job job) {
        jr.save(job);
    }

    @Override
    public Job getJobByid(Long id) {
//        Job j = null;
//        for (Job jobs:l){
//            if (jobs.getJob_id()==id)
//                j=jobs;
//        }
        Optional<Job> j=jr.findById(id);
        if (j.isPresent())
        return j.get();
        return null;
    }
}
