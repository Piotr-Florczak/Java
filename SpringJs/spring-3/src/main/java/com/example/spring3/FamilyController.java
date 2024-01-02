package com.example.spring3;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value= "/api/v2")
public class FamilyController {

    FamilyRepository familyRepository;
    public FamilyController(FamilyRepository familyRepository) {this.familyRepository = familyRepository;}

    List<Family> familyList = new ArrayList<>();

    List<Mamber> members = new ArrayList<>();

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public List<Family> getAll(){

        members.add(new Mamber("Alicja",39,"K"));
        members.add(new Mamber("Piotr",32,"M"));
        members.add(new Mamber("Adam",14,"M"));

        familyList.add(new Family(UUID.randomUUID().toString(),"Kowalki",members));
        familyList.add(new Family(UUID.randomUUID().toString(),"Nowak",members));


        return familyList;
    }

    @RequestMapping(value = "/getByName", method = RequestMethod.GET)
    public Family getByName(@RequestParam String familyName){

        members.add(new Mamber("Alicja",39,"K"));
        members.add(new Mamber("Piotr",32,"M"));
        members.add(new Mamber("Adam",14,"M"));

        familyList.add(new Family(UUID.randomUUID().toString(),"Kowalski",members));
        familyList.add(new Family(UUID.randomUUID().toString(),"Nowak",members));

        return familyList.stream().filter(family -> family.getName().equals(familyName)).findFirst().orElseThrow();
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public void createFamily(@RequestBody Family family)
    {


        if (family.getName() != null && !family.getMambers().isEmpty())
        {
            familyList.add(family);

            return;
        }
    }

    @GetMapping("findByName")
    public List<FamilyDB> createFamilyDB(@RequestParam String name) {
        return familyRepository.findByName(name);
    }

    @PostMapping("insertName")
    @Transactional
    public void insertName(@RequestParam String name)
    {
        familyRepository.insertName(name);
    }

}
