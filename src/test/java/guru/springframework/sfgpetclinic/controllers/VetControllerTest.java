package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class VetControllerTest {

    VetController vetController;
    VetService vetService;
    SpecialtyService specialtyService;

    @BeforeEach
    void setUp() {
        specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);
        vetController = new VetController(vetService);

        Vet vet1 = new Vet(1l, "Victor", "Wardi", getSpecialities());
        Vet vet2 = new Vet(2l, "Ursula", "Wardi", getSpecialities());

        vetService.save(vet1);
        vetService.save(vet2);
    }

    private Set<Speciality> getSpecialities() {
        Speciality dogs = new Speciality("Dogs Specialty");
        Speciality birds = new Speciality("Birds Specialty");
        Set<Speciality> specialities = new HashSet<>();
        specialities.add(dogs);
        specialities.add(birds);
        return specialities;
    }

    @Test
    void testListVets() {

        Model model = new ModelMapImpl();
        String listVetsPage = this.vetController.listVets(model);

        assertTrue("vets/index".equals(listVetsPage));
        Set modelAttributes = (Set) ((ModelMapImpl) model).getMap().get("vets");

        assertTrue(modelAttributes.size() == 2);
    }
}