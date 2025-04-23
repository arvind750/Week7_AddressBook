package com.bridgelabz.addressBook.service;


import com.bridgelabz.addressBook.dto.AddressBookDTO;
import com.bridgelabz.addressBook.modle.AddressBookModel;

import java.util.List;

public interface AddressBookService {
    List<AddressBookModel> getAllEntries();
    AddressBookModel getEntryById(int id);
    AddressBookModel createEntry(AddressBookDTO dto);
    AddressBookModel updateEntry(int id, AddressBookDTO dto);
    void deleteEntry(int id);
}
