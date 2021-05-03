package service;

import entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AddressRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("addressService")
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address findAddressById(long id) {
        return addressRepository.getOne(id);
    }

    @Override
    public Address updateAddress(long id, Address address) {
        Address addressFromDatabase = addressRepository.getOne(id);
        addressFromDatabase.setCountry(address.getCountry());
        addressFromDatabase.setCity(address.getCity());
        addressFromDatabase.setZipCode(address.getZipCode());
        addressFromDatabase.setStreet(address.getStreet());
        addressFromDatabase.setStreetNumber(address.getStreetNumber());
        addressRepository.flush();
        Address updatedAddress = addressRepository.getOne(id);
        return updatedAddress;
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddressById(long id) {
        addressRepository.deleteById(id);
    }
}
