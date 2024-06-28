package com.practice.Practice.service.impl;
import java.util.List;
import org.springframework.stereotype.Service;
import com.practice.Practice.entity.Office;
import com.practice.Practice.repository.OfficeRepository;
import com.practice.Practice.service.OfficeService;

@Service
public class OfficeServiceImpl implements OfficeService {

    private OfficeRepository officeRepository;

    public OfficeServiceImpl(OfficeRepository officeRepository) {
        super();
        this.officeRepository = officeRepository;
    }

    @Override
    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }

    @Override
    public Office saveOffice(Office office) {
        return officeRepository.save(office);
    }

    @Override
    public Office getOfficeById(Long id) {
        return officeRepository.findById(id).get();
    }

    @Override
    public Office updateOffice(Office office) {
        return officeRepository.save(office);
    }

    @Override
    public void deleteOfficeById(Long id) {
        officeRepository.deleteById(id);
    }
}
