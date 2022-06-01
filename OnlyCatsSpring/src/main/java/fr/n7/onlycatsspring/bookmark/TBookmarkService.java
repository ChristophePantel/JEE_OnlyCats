package fr.n7.onlycatsspring.bookmark;

import fr.n7.onlycatsspring.account.TAccount;
import fr.n7.onlycatsspring.post.TPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TBookmarkService {
    public final TBookmarkRepository br;

    @Autowired
    public TBookmarkService(TBookmarkRepository br) {
        this.br = br;
    }

    public TBookmark createBookmark(Optional<TPost> post, TAccount account) {
        TBookmark bookmark = new TBookmark();
        bookmark.setAccount(account);
        post.ifPresent(bookmark::setPost);
        return br.save(bookmark);
    }

    public void deleteBookmark(Integer accountId, Integer postId) {
        TBookmark bookmark = br.findByAccountIdAndPostId(accountId, postId);
        br.delete(bookmark);
    }
}
