package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Pharmacy;


@Repository
public interface PharmacyRepo extends JpaRepository<Pharmacy, Long> {
}
