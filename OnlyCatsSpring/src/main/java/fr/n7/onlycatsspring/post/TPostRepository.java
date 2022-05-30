package fr.n7.onlycatsspring.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TPostRepository extends JpaRepository<TPost, Integer> {
}