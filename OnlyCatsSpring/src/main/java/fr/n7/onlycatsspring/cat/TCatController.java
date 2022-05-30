package fr.n7.onlycatsspring.cat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path= "api/projects")
@CrossOrigin(origins = "*")
public class TCatController {
    @Autowired
    private final TCatService cs;

    @Autowired
    public TCatController(TCatService cs) {
        this.cs = cs;
    }

    @PostMapping("/cat")
    void addCat(@RequestBody TCat newCat) {
        System.out.println(newCat);
        cs.addCat(newCat);
    }

}
