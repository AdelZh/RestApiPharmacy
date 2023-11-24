package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Worker;


@Repository
public interface WorkerRepo extends JpaRepository<Worker, Long> {


}
