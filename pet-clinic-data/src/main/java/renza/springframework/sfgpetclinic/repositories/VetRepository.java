package renza.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import renza.springframework.sfgpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
