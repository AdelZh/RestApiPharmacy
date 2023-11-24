package peaksoft.service.impl;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.entity.Medicine;
import peaksoft.entity.Worker;
import peaksoft.repo.MedicineRepo;
import peaksoft.service.MedicineService;

import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class MedicineSerImpl implements MedicineService {

    @Autowired
    private MedicineRepo medicineRepo;

    @Override
    public List<Medicine> getAllPriceBySort(String ascDesc) {
        List<Medicine> medicines = medicineRepo.findAll();
        if ("asc".equalsIgnoreCase(ascDesc)) {
            medicines.sort(Comparator.comparing(Medicine::getPrice));
        } else if ("desc".equalsIgnoreCase(ascDesc)) {
            medicines.sort(Comparator.comparing(Medicine::getPrice).reversed());
        }
        return medicines;
    }


    @Override
    public List<Medicine> getAll() {
        return medicineRepo.findAll();
    }

    @Override
    public Medicine saveMedicine(Medicine medicine) {
        medicineRepo.save(medicine);
        return medicine;
    }
}
