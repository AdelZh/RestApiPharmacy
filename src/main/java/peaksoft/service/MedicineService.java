package peaksoft.service;

import peaksoft.entity.Medicine;

import java.util.List;

public interface MedicineService {


    List<Medicine> getAllPriceBySort(String ascDesc);

    List<Medicine> getAll();
    Medicine saveMedicine(Medicine medicine);
}
