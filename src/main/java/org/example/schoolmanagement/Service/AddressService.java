package org.example.schoolmanagement.Service;

import lombok.RequiredArgsConstructor;
import org.example.schoolmanagement.Api.ApiException;
import org.example.schoolmanagement.DTO.IN.AddressDTOIN;
import org.example.schoolmanagement.DTO.OUT.AddressDTOut;
import org.example.schoolmanagement.Model.Address;
import org.example.schoolmanagement.Model.Teacher;
import org.example.schoolmanagement.Repository.AddressRepository;
import org.example.schoolmanagement.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;


    public List<AddressDTOut> getAll(){
        List<AddressDTOut> addressDTOuts = new ArrayList<>();

        for (Address address : addressRepository.findAll()){
            addressDTOuts.add(convertToDTO(address));
        }
        return addressDTOuts;
    }


    public void addAddress(Integer id, AddressDTOIN addressDTOIN){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null){
            throw new ApiException("teacher not found");
        }
        Address address = new Address();
        address.setArea(addressDTOIN.getArea());
        address.setStreet(addressDTOIN.getStreet());
        address.setBuildingNumber(addressDTOIN.getBuildingNumber());
        address.setTeacher(teacher);

        addressRepository.save(address);
    }

    public void updateAddress(Integer id, AddressDTOIN addressDTOIN){
        Address address = addressRepository.findAddressById(id);
        if (address==null){
            throw new ApiException("address not found");
        }
        address.setArea(addressDTOIN.getArea());
        address.setStreet(addressDTOIN.getStreet());
        address.setBuildingNumber(addressDTOIN.getBuildingNumber());
        addressRepository.save(address);
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


    public AddressDTOut convertToDTO(Address address){
        AddressDTOut addressDTOut = new AddressDTOut();
        addressDTOut.setArea(address.getArea());
        addressDTOut.setStreet(addressDTOut.getStreet());
        addressDTOut.setBuildingNumber(addressDTOut.getBuildingNumber());
        return addressDTOut;
    }

}
