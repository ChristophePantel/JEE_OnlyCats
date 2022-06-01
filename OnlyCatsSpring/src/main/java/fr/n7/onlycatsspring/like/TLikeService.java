package fr.n7.onlycatsspring.like;

import fr.n7.onlycatsspring.account.TAccount;
import fr.n7.onlycatsspring.cat.TCat;
import fr.n7.onlycatsspring.cat.TCatRepository;
import fr.n7.onlycatsspring.comment.TComment;
import fr.n7.onlycatsspring.post.TPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TLikeService {

    public final TLikeRepository lr;

    @Autowired
    public TLikeService(TLikeRepository lr) {
        this.lr = lr;
    }

    public TLike createLike(Optional<TPost> post, TAccount account) {
        TLike like = new TLike();
        like.setAccount(account);
        post.ifPresent(like::setPost);
        return lr.save(like);
    }

    public void deleteLike(Integer accountId, Integer postId) {
        TLike like = lr.findByAccountIdAndPostId(accountId, postId);
        lr.delete(like);
    }
}
