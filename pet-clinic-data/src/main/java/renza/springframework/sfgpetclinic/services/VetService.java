package renza.springframework.sfgpetclinic.services;

import renza.springframework.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById (Long id);

    Vet save (Vet vet);

    Set<Vet> findAll();

}
