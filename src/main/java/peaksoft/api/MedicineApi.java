package peaksoft.api;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Medicine;

import peaksoft.service.MedicineService;

import java.util.List;

@RestController
@RequestMapping("/medicine")
@RequiredArgsConstructor
public class MedicineApi {

    private final MedicineService medicineService;

    @GetMapping("/getAll")
    public List<Medicine> getAll(){
        return medicineService.getAll();
    }

    @PostMapping("/create")
    public Medicine save(@RequestBody Medicine medicine){
        return medicineService.saveMedicine(medicine);
    }



    @GetMapping("/sortByPrice")
    public List<Medicine> getAllByPriceSort(@RequestParam String ascDesc) {
        return medicineService.getAllPriceBySort(ascDesc);
    }
}


