package service;

import entity.Address;
import java.util.List;

public interface AddressService {

    List<Address> getAllAddresses();

    Address findAddressById (long id);

    Address updateAddress (long id, Address address);

    Address saveAddress (Address address);

    void deleteAddressById (long id);

}
