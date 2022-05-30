package fr.n7.onlycatsspring.like;

import fr.n7.onlycatsspring.cat.TCat;
import fr.n7.onlycatsspring.cat.TCatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TLikeService {

    public final TLikeRepository lr;

    @Autowired
    public TLikeService(TLikeRepository lr) {
        this.lr = lr;
    }

    public void addLike(TLike newLike) {
        lr.save(newLike);
    }

}
