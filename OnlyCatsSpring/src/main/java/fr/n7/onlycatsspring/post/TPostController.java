package fr.n7.onlycatsspring.post;

import fr.n7.onlycatsspring.cat.TCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path= "api/projects")
@CrossOrigin(origins = "*")
public class TPostController {
    @Autowired
    private final TPostService ps;

    @Autowired
    public TPostController(TPostService ps) {
        this.ps = ps;
    }

    @PostMapping("/post")
    void addPost(@RequestBody TPost newPost) {
        System.out.println(newPost);
        ps.addPost(newPost);
    }

}
