package fr.n7.onlycatsspring.post;

import fr.n7.onlycatsspring.cat.TCat;
import fr.n7.onlycatsspring.cat.TCatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TPostService {

    public final TPostRepository pr;

    @Autowired
    public TPostService(TPostRepository pr) {
        this.pr = pr;
    }

    public void addPost(TPost newPost) {
        pr.save(newPost);
    }

}
