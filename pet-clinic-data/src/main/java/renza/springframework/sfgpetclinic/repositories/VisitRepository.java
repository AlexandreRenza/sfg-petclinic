package renza.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import renza.springframework.sfgpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
