package fr.n7.onlycatsspring.comment;

import fr.n7.onlycatsspring.account.TAccount;
import fr.n7.onlycatsspring.post.TPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TCommentService {

    public final TCommentRepository cr;

    @Autowired
    public TCommentService(TCommentRepository cr) {
        this.cr = cr;
    }

    public TComment addComment(TComment newComment) {
        return cr.save(newComment);
    }

    public TComment createComment(Optional<TPost> post, TAccount account, String text) {
        TComment comment = new TComment();
        comment.setAccount(account);
        post.ifPresent(comment::setPost);
        comment.setText(text);
        return cr.save(comment);
    }
}
