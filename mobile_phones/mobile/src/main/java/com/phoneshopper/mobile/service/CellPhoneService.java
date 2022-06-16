package com.phoneshopper.mobile.service;


import com.phoneshopper.mobile.model.CellPhone;
import com.phoneshopper.mobile.repository.CellPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class CellPhoneService {
    private final CellPhoneRepository cellPhoneRepository;

    @Autowired()
    public CellPhoneService(CellPhoneRepository cellPhoneRepository) {
        this.cellPhoneRepository = cellPhoneRepository;
    }

    public CellPhone createCellPhone(CellPhone cell) {
        return this.cellPhoneRepository.save(cell);
    }
}
