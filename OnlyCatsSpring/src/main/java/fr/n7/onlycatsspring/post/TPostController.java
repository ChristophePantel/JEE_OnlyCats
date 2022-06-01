package fr.n7.onlycatsspring.post;

import fr.n7.onlycatsspring.account.TAccount;
import fr.n7.onlycatsspring.account.TAccountService;
import fr.n7.onlycatsspring.cat.TCat;
import fr.n7.onlycatsspring.subscriptions.TSubscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.*;

@RestController
@RequestMapping(path= "posts")
@CrossOrigin(origins = "*")
public class TPostController {
    @Autowired
    private final TPostService ps;

    @Autowired
    private final TAccountService as;

    @Autowired
    public TPostController(TPostService ps, TAccountService as) {
        this.ps = ps;
        this.as = as;
    }

    @PostMapping("/create")
    TPost addPost(@RequestBody TPost newPost) {
        return  ps.addPost(newPost);
    }

    @GetMapping("/{id}")
    Optional<TPost> getById(@PathVariable("id") Integer id) {
        return ps.getById(id);
    }

    @GetMapping("/by_profile/{id}")
    Set<TPost> getByAccountId(@PathVariable("id") Integer id) {
        return ps.getPostsByAccountId(id);
    }

    @GetMapping("/by_cat/{id}")
    Set<TPost> getByCatId(@PathVariable("id") Integer id) {
        return ps.getPostsByCatId(id);
    }

    @PostMapping("/")
    Set<TPost> getBySubs(@RequestBody Map<String, String> body) {

        Integer accountId = Integer.parseInt(body.get("id_account"));
        System.out.println(accountId);
        TAccount account = as.findById(accountId);
        System.out.println(account);
        Set<TSubscription> subs = account.getSubs();
        System.out.println(subs);
        Set<TCat> cats = new HashSet<>();
        subs.forEach(s -> cats.add(s.getCat()));
        System.out.println(cats);
        Set<TPost> posts = new HashSet<>();
        cats.forEach(c -> {
            Set<TPost> postsForCat = ps.getPostsByCatId(c.getId());
            posts.addAll(postsForCat);
        });
        System.out.println(posts);
        return posts;
    }

}
