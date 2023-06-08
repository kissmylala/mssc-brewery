package adem.springframework.msccbrewery.web.controller;

import adem.springframework.msccbrewery.services.CustomerService;
import adem.springframework.msccbrewery.web.model.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto){
        CustomerDto savedDto = customerService.saveNewCustomer(customerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","api/v1/customer/"+savedDto.getId().toString());
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }
    @PutMapping("/{customerId}")
    public ResponseEntity handleUpdate(@PathVariable("customerId") UUID customerId,@RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerId,customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/customerId")
    public void deleteCustomer(UUID customerId){
        customerService.deleteById(customerId);
    }


}
