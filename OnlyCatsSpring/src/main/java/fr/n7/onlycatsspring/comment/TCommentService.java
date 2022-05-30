package fr.n7.onlycatsspring.comment;

import fr.n7.onlycatsspring.cat.TCat;
import fr.n7.onlycatsspring.cat.TCatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TCommentService {

    public final TCommentRepository cr;

    @Autowired
    public TCommentService(TCommentRepository cr) {
        this.cr = cr;
    }

    public void addComment(TComment newComment) {
        cr.save(newComment);
    }

}
