package fr.n7.onlycatsspring.bookmark;

import fr.n7.onlycatsspring.account.TAccount;
import fr.n7.onlycatsspring.account.TAccountService;
import fr.n7.onlycatsspring.post.TPost;
import fr.n7.onlycatsspring.post.TPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "bookmarks")
@CrossOrigin(origins = "*")
public class TbookmarkController {
    @Autowired
    private final TAccountService as;

    @Autowired
    private final TPostService ps;

    @Autowired
    private final TBookmarkService bs;

    public TbookmarkController(TAccountService as, TPostService ps, TBookmarkService bs) {
        this.as = as;
        this.ps = ps;
        this.bs = bs;
    }

    @PostMapping("/create")
    TBookmark addBookmark(@RequestBody Map<String, String> body) {
        TAccount account = as.findById(Integer.parseInt(body.get("id_account")));
        Optional<TPost> post = ps.getById(Integer.parseInt(body.get("id_post")));
        return bs.createBookmark(post, account);
    }

    @PostMapping("/delete")
    void deleteBookmark(@RequestBody Map<String, String> body) {
        bs.deleteBookmark(Integer.parseInt(body.get("id_account")), Integer.parseInt(body.get("id_post")));
    }

    @PostMapping("/get")
    void getBookmarksByAccountId() {}
}
