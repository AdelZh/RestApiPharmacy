package peaksoft.service;

import peaksoft.entity.Medicine;
import peaksoft.entity.Pharmacy;

import java.util.List;

public interface PharmacyService {


    List<Medicine> getAllMedicineByPharmacyId(Long pharmacyId);
    List<Pharmacy> getPharmacyByWorkerId(Long id);

    void searchByPharmacyId(Long id);
    Pharmacy savePharmacy(Pharmacy pharmacy);

}
