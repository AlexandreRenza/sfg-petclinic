package renza.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import renza.springframework.sfgpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
