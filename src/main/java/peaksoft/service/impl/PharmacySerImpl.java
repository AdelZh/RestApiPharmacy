package peaksoft.service.impl;


import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.entity.Medicine;
import peaksoft.entity.Pharmacy;
import peaksoft.entity.Worker;
import peaksoft.repo.PharmacyRepo;
import peaksoft.repo.WorkerRepo;
import peaksoft.service.PharmacyService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class PharmacySerImpl implements PharmacyService {

    @Autowired
    private PharmacyRepo pharmacyRepo;
    @Autowired
    private WorkerRepo workerRepo;

    @Override
    public List<Medicine> getAllMedicineByPharmacyId(Long pharmacyId) {
        Pharmacy pharmacy=pharmacyRepo.findById(pharmacyId).orElseThrow(() -> new EntityNotFoundException("not found: "+pharmacyId));
        if(pharmacy != null && pharmacy.getMedicine() != null){
            return new ArrayList<>(pharmacy.getMedicine());
        }else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<Pharmacy> getPharmacyByWorkerId(Long id) {
        Worker worker=workerRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("not founded: "+id));
        return new ArrayList<>(Collections.singleton(worker.getPharmacy()));
    }


    @Override
    public Pharmacy savePharmacy(Pharmacy pharmacy) {
        pharmacyRepo.save(pharmacy);
       return pharmacy;
    }

    @Override
    public void searchByPharmacyId(Long id) {

    }
}
