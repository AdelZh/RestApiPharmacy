package peaksoft.api;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Medicine;
import peaksoft.entity.Pharmacy;
import peaksoft.service.PharmacyService;

import java.util.List;

@RestController
@RequestMapping("/pharmacy")
@RequiredArgsConstructor
public class PharmacyApi {

    private final PharmacyService pharmacyService;


    @PostMapping("/create")
    public Pharmacy save(@RequestBody Pharmacy pharmacy) {
        return pharmacyService.savePharmacy(pharmacy);
    }


    @GetMapping("/medicine")
    public List<Medicine> getAllMedicineByPharmacyId(@RequestParam Long pharmacyId) {
        return pharmacyService.getAllMedicineByPharmacyId(pharmacyId);
    }

    @GetMapping("/worker")
    public List<Pharmacy> getPharmacyByWorkerId(@RequestParam Long workerId){
        return pharmacyService.getPharmacyByWorkerId(workerId);
    }

}




