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
import peaksoft.service.WorkerService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class WorkerSerImpl implements WorkerService {

    @Autowired
    private WorkerRepo workerRepo;
    @Autowired
    private PharmacyRepo pharmacyRepo;

    @Override
    public List<Worker> getAllWorkerByPharmacyId(Long id) {
        Pharmacy pharmacy = pharmacyRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("not founded: " + id));
        if (pharmacy != null && pharmacy.getWorkers() != null) {
            return new ArrayList<>(pharmacy.getWorkers());
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<Worker> getAllSalaryBySort(String ascDesc) {
        List<Worker> workers = workerRepo.findAll();
        if ("asc".equalsIgnoreCase(ascDesc)) {
            workers.sort(Comparator.comparing(Worker::getSalary));
        } else if ("desc".equalsIgnoreCase(ascDesc)) {
            workers.sort(Comparator.comparing(Worker::getSalary).reversed());
        }
        return workers;
    }




    @Override
    public Worker saveWorker(Worker worker) {
        workerRepo.save(worker);
       return worker;
    }
}