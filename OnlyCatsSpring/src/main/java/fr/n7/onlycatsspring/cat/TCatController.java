package fr.n7.onlycatsspring.cat;

import fr.n7.onlycatsspring.account.TAccount;
import fr.n7.onlycatsspring.account.TAccountService;
import fr.n7.onlycatsspring.post.TPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(path= "cats")
@CrossOrigin(origins = "*")
public class TCatController {
    @Autowired
    private final TCatService cs;

    @Autowired
    private final TAccountService as;

    @Autowired
    private final TPostService ps;

    @Autowired
    public TCatController(TCatService cs, TAccountService as, TPostService ps) {
        this.cs = cs;
        this.as = as;
        this.ps = ps;
    }

    @GetMapping("/{id}")
    TCat getCatById(@PathVariable("id") Integer id) {
        return cs.getById(id);
    }

    @PostMapping("/create")
    TCat addCat(@RequestBody Map<String, String> body) {
        TCat newCat = new TCat();
        newCat.setImage(body.get("image"));
        newCat.setName(body.get("name"));
        TAccount account = as.findById(Integer.parseInt(body.get("owner_id")));
        newCat.setOwner(account);
        return cs.addCat(newCat);
    }

    @PostMapping("/search")
    Set<TCat> searchCats(@RequestBody Map<String, String> body) {
        return cs.searchByName(body.get("name"));
    }
}
