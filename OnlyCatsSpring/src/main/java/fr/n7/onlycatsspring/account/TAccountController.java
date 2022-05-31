package fr.n7.onlycatsspring.account;

import fr.n7.onlycatsspring.cat.TCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping(path= "account")
@CrossOrigin(origins = "*")
public class TAccountController {
    @Autowired
    private final TAccountService as;

    @Autowired
    public TAccountController(TAccountService as) {
        this.as = as;
    }

    @PostMapping("/create")
    TAccount addAccount(@RequestBody TAccount newAccount) {
        return as.addAccount(newAccount);
    }

    @PostMapping("/login")
    TAccount loginToAccount(@RequestBody Map<String, String> body) {
        return as.findByEmailAndPassword(body.get("email"), body.get("password"));
    }

    @GetMapping("/{id}")
    TAccount getAccountById(@PathVariable Integer id) {
        TAccount result = as.findById(id);
        // use this to fetch lazy fields
        result.getCats().forEach(TCat::getPosts);

        return result;
    }
}
