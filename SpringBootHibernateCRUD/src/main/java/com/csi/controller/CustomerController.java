package com.csi.controller;

import com.csi.model.Customer;
import com.csi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerServiceImpl;

    @PostMapping("/savedata")
    public ResponseEntity<String>saveData(@RequestBody Customer customer){

        customerServiceImpl.saveData(customer);

        return ResponseEntity.ok("Customer data save successfully");
    }

    @GetMapping("/getdatabyid/{custId}")

    public ResponseEntity<Customer> getDataById(@PathVariable int custId){

        return ResponseEntity.ok(customerServiceImpl.getDataById(custId));
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Customer>>getAllData(){
        return ResponseEntity.ok(customerServiceImpl.getAllData());
    }

    @PutMapping("/updatedata/{custId}")
    public ResponseEntity<String>updateDataById(@PathVariable int custId, @RequestBody Customer customer){
        customerServiceImpl.updateData(custId,customer);

        return ResponseEntity.ok("Customer Data Updated Successfully");

    }

    @DeleteMapping("/deletedata/{custId}")
    public ResponseEntity<String>deleteById(@PathVariable int custId){
        customerServiceImpl.deleteDataById(custId);

        return ResponseEntity.ok("Customer Data Deleted Successfully");
    }


    @GetMapping("/hey")
    public String sayHello(){
        return "Welcome to CSI";
    }

    @GetMapping("/hello")
    public String sayWelcome(){
        return  "Pune MH";
    }
}
