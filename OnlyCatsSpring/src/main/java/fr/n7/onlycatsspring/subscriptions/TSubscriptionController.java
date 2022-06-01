package fr.n7.onlycatsspring.subscriptions;

import fr.n7.onlycatsspring.account.TAccount;
import fr.n7.onlycatsspring.account.TAccountService;
import fr.n7.onlycatsspring.cat.TCat;
import fr.n7.onlycatsspring.cat.TCatService;
import fr.n7.onlycatsspring.like.TLike;
import fr.n7.onlycatsspring.post.TPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("subs")
@CrossOrigin(origins = "*")
public class TSubscriptionController {
    @Autowired
    private final TSubscriptionService ss;

    @Autowired
    private final TCatService cs;

    @Autowired
    private final TAccountService as;

    public TSubscriptionController(TSubscriptionService ss, TCatService cs, TAccountService as) {
        this.ss = ss;
        this.cs = cs;
        this.as = as;
    }

    @PostMapping("/create")
    TSubscription addLike(@RequestBody Map<String, String> body) {
        TAccount account = as.findById(Integer.parseInt(body.get("id_account")));
        TCat cat = cs.getById(Integer.parseInt(body.get("id_cat")));
        return ss.createTSub(cat, account);
    }

    @PostMapping("/delete")
    void deleteLike(@RequestBody Map<String, String> body) {
        ss.deleteSub(Integer.parseInt(body.get("id_account")), Integer.parseInt(body.get("id_cat")));
    }
}
