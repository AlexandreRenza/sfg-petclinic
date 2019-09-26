package renza.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import renza.springframework.sfgpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
