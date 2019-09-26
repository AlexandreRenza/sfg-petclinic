package renza.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import renza.springframework.sfgpetclinic.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
