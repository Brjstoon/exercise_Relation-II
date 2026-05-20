package org.example.schoolmanagement.Service;

import lombok.RequiredArgsConstructor;
import org.example.schoolmanagement.Api.ApiException;
import org.example.schoolmanagement.Model.Address;
import org.example.schoolmanagement.Model.Teacher;
import org.example.schoolmanagement.Repository.AddressRepository;
import org.example.schoolmanagement.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;


    public List<Address> getAll(){
        return addressRepository.findAll();
    }


    public void addAddress(Address address){
        addressRepository.save(address);
    }
    public void updateAddress(Integer id, Address address){
        Address oldAddress = addressRepository.findAddressById(id);
        if (oldAddress==null){
            throw new ApiException("address not found");
        }
        oldAddress.setArea(address.getArea());
        oldAddress.setStreet(address.getStreet());
        oldAddress.setBuildingNumber(address.getBuildingNumber());
        addressRepository.save(oldAddress);
    }
    public void deleteAddress(Integer id){
        Address address = addressRepository.findAddressById(id);
        if (address==null){
            throw new ApiException("address not found");
        }
        Teacher teacher = address.getTeacher();
        teacher.setAddress(null);
        addressRepository.deleteById(id);
    }



}
