package fr.n7.onlycatsspring.comment;

import fr.n7.onlycatsspring.account.TAccount;
import fr.n7.onlycatsspring.account.TAccountService;
import fr.n7.onlycatsspring.post.TPost;
import fr.n7.onlycatsspring.post.TPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path= "comments")
@CrossOrigin(origins = "*")
public class TCommentController {
    @Autowired
    private final TCommentService cs;

    @Autowired
    private final TPostService ps;

    @Autowired
    private final TAccountService as;

    @Autowired
    public TCommentController(TCommentService cs, TPostService ps, TAccountService as) {
        this.cs = cs;
        this.ps = ps;
        this.as = as;
    }

    @PostMapping("/create")
    TComment addComment(@RequestBody Map<String, String> body) {
        TAccount account = as.findById(Integer.parseInt(body.get("id_account")));
        Optional<TPost> post = ps.getById(Integer.parseInt(body.get("id_post")));
        return cs.createComment(post, account, body.get("text"));
    }

}
