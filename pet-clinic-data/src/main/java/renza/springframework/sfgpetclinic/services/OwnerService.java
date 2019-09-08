package renza.springframework.sfgpetclinic.services;

import renza.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName (String lastName);

}
