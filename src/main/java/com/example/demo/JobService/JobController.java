package com.example.demo.JobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//sets base url for all methods
    @RequestMapping("/job")
public class JobController {
    JobService js;

    @Autowired
    public JobController(JobService js) {
        this.js = js;
    }
//to get all jobs
    @GetMapping("/jobs")
   public ResponseEntity<List<Job>> getJobs(){
            return new ResponseEntity<>(js.findAll(),HttpStatus.OK);
   }
// to add job
   @PostMapping("/addJob")
   public ResponseEntity<String> addJob(@RequestBody Job job){
        js.add(job);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
   }
//   to get job by id
//    if i use return type as Job then if id not found it will return null and http status will be '200 OK' which is not very informative
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getById(@PathVariable Long id){
        Job j=js.getJobByid(id);
        if (j!=null)
            return new ResponseEntity<>(j, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
