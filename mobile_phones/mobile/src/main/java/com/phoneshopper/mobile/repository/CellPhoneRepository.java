package com.phoneshopper.mobile.repository;

import com.phoneshopper.mobile.model.CellPhone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface CellPhoneRepository extends CrudRepository<CellPhone, Long> {
}
