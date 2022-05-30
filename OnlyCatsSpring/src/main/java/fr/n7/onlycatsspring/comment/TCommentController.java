package fr.n7.onlycatsspring.comment;

import fr.n7.onlycatsspring.cat.TCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path= "api/projects")
@CrossOrigin(origins = "*")
public class TCommentController {
    @Autowired
    private final TCommentService cs;

    @Autowired
    public TCommentController(TCommentService cs) {
        this.cs = cs;
    }

    @PostMapping("/comment")
    void addComment(@RequestBody TComment newComment) {
        System.out.println(newComment);
        cs.addComment(newComment);
    }

}
