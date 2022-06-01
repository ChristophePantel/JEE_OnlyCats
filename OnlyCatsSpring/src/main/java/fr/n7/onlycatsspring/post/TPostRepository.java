package fr.n7.onlycatsspring.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface TPostRepository extends JpaRepository<TPost, Integer> {
    Set<TPost> findByCatId(Integer id);

    Set<TPost> findAllByAccount_Id(Integer id);

    Set<TPost> findAllByCat_Id(Integer id);

    Optional<TPost> findById(Integer id);
}