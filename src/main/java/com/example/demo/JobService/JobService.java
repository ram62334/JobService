package com.example.demo.JobService;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void add(Job job);

    Job getJobByid(Long id);
}
