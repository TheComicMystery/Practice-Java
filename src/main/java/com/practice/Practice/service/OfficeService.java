package com.practice.Practice.service;

import java.util.List;

import com.practice.Practice.entity.Office;

public interface OfficeService {
    List<Office> getAllOffices();

    Office saveOffice(Office office);

    Office getOfficeById(Long id);

    Office updateOffice(Office office);

    void deleteOfficeById(Long id);
}
