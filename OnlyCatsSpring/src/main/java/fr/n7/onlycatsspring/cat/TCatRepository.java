package fr.n7.onlycatsspring.cat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TCatRepository extends JpaRepository<TCat, String> {
}