package fr.n7.onlycatsspring.like;

import fr.n7.onlycatsspring.account.TAccount;
import fr.n7.onlycatsspring.account.TAccountService;
import fr.n7.onlycatsspring.comment.TComment;
import fr.n7.onlycatsspring.post.TPost;
import fr.n7.onlycatsspring.post.TPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path= "like")
@CrossOrigin(origins = "*")
public class TLikeController {
    @Autowired
    private final TLikeService ls;

    @Autowired
    private final TPostService ps;

    @Autowired
    private final TAccountService as;

    @Autowired
    public TLikeController(TLikeService ls, TPostService ps, TAccountService as) {
        this.ls = ls;
        this.ps = ps;
        this.as = as;
    }

    @PostMapping("/create")
    TLike addLike(@RequestBody Map<String, String> body) {
        TAccount account = as.findById(Integer.parseInt(body.get("id_account")));
        Optional<TPost> post = ps.getById(Integer.parseInt(body.get("id_post")));
        return ls.createLike(post, account);
    }

    @PostMapping("/delete")
    void deleteLike(@RequestBody Map<String, String> body) {
        ls.deleteLike(Integer.parseInt(body.get("id_account")), Integer.parseInt(body.get("id_post")));
    }
}
