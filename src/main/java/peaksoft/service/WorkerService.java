package peaksoft.service;

import peaksoft.entity.Medicine;
import peaksoft.entity.Pharmacy;
import peaksoft.entity.Worker;

import java.util.List;

public interface WorkerService {




    List<Worker> getAllWorkerByPharmacyId(Long id);
    List<Worker> getAllSalaryBySort(String ascDesc);

    Worker saveWorker(Worker worker);
}
