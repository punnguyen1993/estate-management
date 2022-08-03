package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.TransactionTypeDTO;
import com.laptrinhjavaweb.service.ICustomerService;
import com.laptrinhjavaweb.service.ITransactionService;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.utils.DisplayTagUtils;
import com.laptrinhjavaweb.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller(value = "customerControllerOfAdmin")
public class CustomerController {

    @Autowired
    IUserService userService;
    @Autowired
    ICustomerService customerService;
    @Autowired
    ITransactionService transactionService;

    @RequestMapping(value = "/admin/customer-list", method = RequestMethod.GET)
    public ModelAndView getCustomer(@ModelAttribute(SystemConstant.MODEL_SEARCH) CustomerDTO customerDTO,
                                    @ModelAttribute(SystemConstant.TABLE_MODEL) CustomerDTO tableCustomerDTO,
                                    HttpServletRequest request) {
        DisplayTagUtils.of(request, tableCustomerDTO);
        ModelAndView mav = new ModelAndView("admin/customer/list");

        List<CustomerDTO> customers;
        if(customerDTO.isSearch()){
            customers = customerService.findByDetail(customerDTO, PageRequest.of(customerDTO.getPage() - 1,
                                                        customerDTO.getMaxPageItems()));
            tableCustomerDTO.setTotalItems(customerService.countTotalSearchingItem(customerDTO));
        }else {
            customers = customerService.findAll(PageRequest.of(tableCustomerDTO.getPage() - 1,
                                                    tableCustomerDTO.getMaxPageItems()));
            tableCustomerDTO.setTotalItems(customerService.countAll());
        }
        tableCustomerDTO.setListResult(customers);

        mav.addObject(SystemConstant.MODEL_SEARCH, customerDTO);
        mav.addObject(SystemConstant.TABLE_MODEL, tableCustomerDTO);
        mav.addObject("staffmaps", userService.getStaffMaps());

        return mav;
    }


    @RequestMapping(value = "/admin/customer-edit", method = RequestMethod.GET)
    public ModelAndView customerEdit(@ModelAttribute(SystemConstant.MODEL_ADDING) CustomerDTO customerDTO) {

        ModelAndView mav = new ModelAndView("admin/customer/edit");
        mav.addObject("customerId", customerDTO.getId());
        mav.addObject(SystemConstant.BUTTON_NAME, SystemConstant.CUSTOMER_ADDING_BUTTON_NAME);

        mav.addObject(SystemConstant.TRANSACTION_TYPES, transactionService.getRestTransactionTypes(null));
        mav.addObject(SystemConstant.MODEL_ADDING, customerDTO);

        return mav;
    }


    @RequestMapping(value = "/admin/customer-edit-{id}", method = RequestMethod.GET)
    public ModelAndView customerEdit(@ModelAttribute(SystemConstant.MODEL_ADDING) CustomerDTO customerDTO,
                                     @PathVariable(value = "id") Long id) {
        ModelAndView mav = new ModelAndView("admin/customer/edit");
        mav.addObject("customerId", id);
        mav.addObject(SystemConstant.BUTTON_NAME, SystemConstant.CUSTOMER_UPDATE_BUTTON_NAME);

        if (ValidateUtils.isValid(id)) {
            mav.addObject(SystemConstant.MODEL_ADDING, customerService.findById(id));
            List<TransactionTypeDTO> transactionType = transactionService.findByCustomerId(id);
            mav.addObject("transactions", transactionType);
            mav.addObject(SystemConstant.TRANSACTION_TYPES, transactionService.getRestTransactionTypes(transactionType));
        } else {
            mav.addObject(SystemConstant.TRANSACTION_TYPES, transactionService.getRestTransactionTypes(null));
            mav.addObject(SystemConstant.MODEL_ADDING, customerDTO);
        }

        return mav;
    }

}
