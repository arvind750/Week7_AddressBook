package com.bridgelabz.addressBook.service;

import com.bridgelabz.addressBook.dto.AddressBookDTO;
import com.bridgelabz.addressBook.modle.AddressBookModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookServiceImpl implements AddressBookService {

    private final List<AddressBookModel> addressList = new ArrayList<>();

    @Override
    public List<AddressBookModel> getAllEntries() {
        return addressList;
    }

    @Override
    public AddressBookModel getEntryById(int id) {
        return addressList.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }

    @Override
    public AddressBookModel createEntry(AddressBookDTO dto) {
        AddressBookModel address = new AddressBookModel(addressList.size() + 1, dto.name, dto.address);
        addressList.add(address);
        return address;
    }

    @Override
    public AddressBookModel updateEntry(int id, AddressBookDTO dto) {
        AddressBookModel address = getEntryById(id);
        if (address != null) {
            address.setName(dto.name);
            address.setAddress(dto.address);
        }
        return address;
    }

    @Override
    public void deleteEntry(int id) {
        addressList.removeIf(a -> a.getId() == id);
    }
}
