package renza.springframework.sfgpetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="types")
public class PetType extends BaseEntity{

    @Column(name= "name")
    private String name ;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "petType")
    private Set<Pet> pets = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
