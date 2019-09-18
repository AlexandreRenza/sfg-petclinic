package renza.springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import renza.springframework.sfgpetclinic.model.*;
import renza.springframework.sfgpetclinic.services.OwnerService;
import renza.springframework.sfgpetclinic.services.PetTypeService;
import renza.springframework.sfgpetclinic.services.SpecialtyService;
import renza.springframework.sfgpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }


    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);


        Owner owner1 = new Owner();
        owner1.setFirstName("Michel");
        owner1.setLastName("Weston");
        owner1.setAddress("7 Livingston Court");
        owner1.setCity("Eatontown");
        owner1.setTelephone("12312313123");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(saveDogPetType);
        mikesPet.setName("Doly");
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Alexandre");
        owner2.setLastName("Rezende");
        owner2.setAddress("7234234234 234234adasdasd Court");
        owner2.setCity("LongBranch");
        owner2.setTelephone("4674567567");


        Pet alexPet = new Pet();
        alexPet.setPetType(saveCatPetType);
        alexPet.setName("Dara");
        alexPet.setOwner(owner2);
        alexPet.setBirthDate(LocalDate.now());
        owner2.getPets().add(alexPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners ....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sabrina");
        vet1.setLastName("Guimarães");
        vet1.getSpecialities().add(savedSurgery);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mariluce");
        vet2.setLastName("Rezende");
        vet2.getSpecialities().add(savedDentistry);

        vetService.save(vet2);

        System.out.println("Loaded Vets ....");
    }
}
