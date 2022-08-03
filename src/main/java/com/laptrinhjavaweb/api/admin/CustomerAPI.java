package com.laptrinhjavaweb.api.admin;


import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.dto.request.AssginStaffsOfCustomerRequest;
import com.laptrinhjavaweb.dto.request.DeleteRequest;
import com.laptrinhjavaweb.dto.response.ResponseDTO;
import com.laptrinhjavaweb.service.ICustomerService;
import com.laptrinhjavaweb.service.ITransactionService;
import com.laptrinhjavaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "customerAPIOfAdmin")
@RequestMapping(value = "/api/customer")
public class CustomerAPI {
    @Autowired
    private IUserService userService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ITransactionService transactionService;

    @PostMapping("/transaction")
    public void addTransaction(@RequestBody TransactionDTO transactionDTO){
        transactionService.addTransaction(transactionDTO);
    }

    @GetMapping("/staffs")
    public ResponseDTO loadStaff(@RequestParam(value = "customerId") Long id){
        return userService.getAllStaffAndChecked(id, SystemConstant.CUSTOMER);
    }

    @PutMapping("/assignment")
    public void assignStaffsForCustomer(@RequestBody AssginStaffsOfCustomerRequest customerRequest){
        customerService.assignStaffsForCustomer(customerRequest);
    }


    @PostMapping()
    public void createCustomer(@RequestBody CustomerDTO newCustomer) {
        customerService.save(newCustomer, null);
    }

    @PutMapping()
    public void updateCustomer(@RequestBody CustomerDTO editingCustomer, @RequestParam(value = "customerId") Long id){
        customerService.save(editingCustomer, id);
    }

    @DeleteMapping()
    public List<CustomerDTO> deleteCustomer(@RequestBody DeleteRequest request) {
        customerService.deleteByIdIn(request);
        return null;
    }
}
