package fr.n7.onlycatsspring.account;

import fr.n7.onlycatsspring.account.TAccount;
import fr.n7.onlycatsspring.account.TAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path= "api/projects")
@CrossOrigin(origins = "*")
public class TAccountController {
    @Autowired
    private final TAccountService as;

    @Autowired
    public TAccountController(TAccountService as) {
        this.as = as;
    }

    @PostMapping("/account")
    void addAccount(@RequestBody TAccount newAccount) {
        System.out.println(newAccount);
        as.addAccount(newAccount);
    }

    @GetMapping("/account")
    String test() {
        return "baydha";
    }

}
