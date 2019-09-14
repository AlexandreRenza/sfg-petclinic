package renza.springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import renza.springframework.sfgpetclinic.model.Owner;
import renza.springframework.sfgpetclinic.model.Vet;
import renza.springframework.sfgpetclinic.services.OwnerService;
import renza.springframework.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Michel");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Alexandre");
        owner2.setLastName("Rezende");

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
