package com.bridgelabz.addressBook.controler;

import com.bridgelabz.addressBook.dto.AddressBookDTO;
import com.bridgelabz.addressBook.modle.AddressBookModel;
import com.bridgelabz.addressBook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbookservice")
public class AddressBookController {

    @Autowired
    private AddressBookService addressService;

    @GetMapping("/")
    public List<AddressBookModel> getAllEntries() {
        return addressService.getAllEntries();
    }

    @GetMapping("/get/{id}")
    public AddressBookModel getEntry(@PathVariable int id) {
        return addressService.getEntryById(id);
    }

    @PostMapping("/create")
    public AddressBookModel createEntry(@RequestBody AddressBookDTO dto) {
        return addressService.createEntry(dto);
    }

    @PutMapping("/update/{id}")
    public AddressBookModel updateEntry(@PathVariable int id, @RequestBody AddressBookDTO dto) {
        return addressService.updateEntry(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEntry(@PathVariable int id) {
        addressService.deleteEntry(id);
    }
}
