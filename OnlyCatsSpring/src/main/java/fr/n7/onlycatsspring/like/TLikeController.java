package fr.n7.onlycatsspring.like;

import fr.n7.onlycatsspring.cat.TCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path= "api/projects")
@CrossOrigin(origins = "*")
public class TLikeController {
    @Autowired
    private final TLikeService ls;

    @Autowired
    public TLikeController(TLikeService ls) {
        this.ls = ls;
    }

    @PostMapping("/like")
    void addLike(@RequestBody TLike newLike) {
        System.out.println(newLike);
        ls.addLike(newLike);
    }

}
