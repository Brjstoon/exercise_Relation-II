package org.example.schoolmanagement.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.schoolmanagement.Api.ApiResponse;
import org.example.schoolmanagement.Model.Address;
import org.example.schoolmanagement.Service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity<?> getAddresses() {
        return ResponseEntity.status(200).body(addressService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAddress(@RequestBody @Valid Address address) {
        addressService.addAddress(address);
        return ResponseEntity.status(200).body(new ApiResponse("address added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable Integer id, @RequestBody @Valid Address address) {
        addressService.updateAddress(id, address);
        return ResponseEntity.status(200).body(new ApiResponse("address updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body(new ApiResponse("address deleted successfully"));
    }

}