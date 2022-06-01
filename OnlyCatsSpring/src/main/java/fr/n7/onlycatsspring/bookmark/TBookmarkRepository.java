package fr.n7.onlycatsspring.bookmark;

import fr.n7.onlycatsspring.like.TLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TBookmarkRepository extends JpaRepository<TBookmark, Integer> {
    TBookmark findByAccountIdAndPostId(Integer account_id, Integer post_id);
}