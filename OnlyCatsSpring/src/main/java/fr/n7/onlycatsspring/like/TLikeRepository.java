package fr.n7.onlycatsspring.like;

import fr.n7.onlycatsspring.like.TLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TLikeRepository extends JpaRepository<TLike, Integer> {
}