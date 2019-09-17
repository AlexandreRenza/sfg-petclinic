package renza.springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import renza.springframework.sfgpetclinic.model.Owner;
import renza.springframework.sfgpetclinic.model.Pet;
import renza.springframework.sfgpetclinic.model.PetType;
import renza.springframework.sfgpetclinic.model.Vet;
import renza.springframework.sfgpetclinic.services.OwnerService;
import renza.springframework.sfgpetclinic.services.PetTypeService;
import renza.springframework.sfgpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {


        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);


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

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mariluce");
        vet2.setLastName("Rezende");

        vetService.save(vet2);

        System.out.println("Loaded Vets ....");
    }
}
