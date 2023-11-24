package peaksoft.api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Pharmacy;
import peaksoft.entity.Worker;
import peaksoft.service.WorkerService;

import java.util.List;


@RestController
@RequestMapping("/worker")
@RequiredArgsConstructor
public class WorkerApi {

    private final WorkerService workerService;


    @PostMapping("/create")
    public Worker save(@RequestBody Worker worker) {
        return workerService.saveWorker(worker);
    }


    @GetMapping("/sortBySalary")
    public List<Worker> getAllSalaryBySort(@RequestParam String ascDesc) {
        return workerService.getAllSalaryBySort(ascDesc);
    }

}


