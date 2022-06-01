package fr.n7.onlycatsspring.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class TPostService {

    public final TPostRepository pr;

    @Autowired
    public TPostService(TPostRepository pr) {
        this.pr = pr;
    }

    public TPost addPost(TPost newPost) {
        return pr.save(newPost);
    }

    public Set<TPost> getPostsByAccountId(Integer id) {
        return pr.findAllByAccount_Id(id);
    }

    public Set<TPost> getPostsByCatId(Integer id) {
        return pr.findAllByCat_Id(id);
    }

    public Optional<TPost> getById(Integer id) {
        return pr.findById(id);
    }
}
