package fr.n7.onlycatsspring.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TCommentRepository extends JpaRepository<TComment, Integer> {
}