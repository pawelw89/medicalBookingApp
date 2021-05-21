package service;

import entity.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.AddressRepository;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AddressServiceImplTestImpl {

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressServiceImpl addressServiceImpl;

    Address a1 = new Address();
    long id = 1L;
    Address a2 = new Address();
    Address a3 = new Address();

    @Test
    void shouldReturnAllAddresses() {
        given(addressRepository.findAll()).willReturn(Arrays.asList(a1, a2, a3));

        List<Address> result = addressServiceImpl.getAllAddresses();

        assertThat(result).hasSize(3);
        Assertions.assertEquals(List.of(a1, a2, a3), result);
    }

    @Test
    void shouldReturnAddressById() {
        a1.setId(id);
        given(addressRepository.getOne(id)).willReturn(a1);

        Address foundAddress = addressServiceImpl.findAddressById(id);

        Assertions.assertEquals(a1, foundAddress);
    }

    @Test
    void shouldUpdateAndReturnUpdatedAddressByPesel() {
        a1.setId(id);
        a2.setCountry("Poland");
        a2.setCity("Cracow");
        given(addressRepository.getOne(id)).willReturn(a2);

        Address updatedAddress = addressServiceImpl.updateAddress(a1.getId(), a2);

        Assertions.assertEquals(a2, updatedAddress);
        Assertions.assertEquals("Poland", updatedAddress.getCountry());
    }

    @Test
    void shouldSaveAndReturnNewAddressByPesel() {
        a1.setId(id);
        given(addressRepository.save(a1)).willReturn(a1);

        Address addressSaved = addressServiceImpl.saveAddress(a1);

        Assertions.assertEquals(a1, addressSaved);
    }

    @Test
    void shouldDeleteAddressById() {
        a1.setId(id);

        addressServiceImpl.deleteAddressById(id);

        verify(addressRepository, times(1)).deleteById(id);
    }
}