
package renza.springframework.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import renza.springframework.sfgpetclinic.model.Specialty;
import renza.springframework.sfgpetclinic.model.Vet;
import renza.springframework.sfgpetclinic.services.SpecialtyService;
import renza.springframework.sfgpetclinic.services.VetService;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService{

    private SpecialtyService specialtyService;

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.finfById(id);
    }

    @Override
    public Vet save(Vet object) {

        if(object.getSpecialities().size() > 0){
            object.getSpecialities().forEach(specialty -> {
                if(specialty.getId()==null){
                    Specialty savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }
}
