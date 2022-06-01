package fr.n7.onlycatsspring.cat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TCatRepository extends JpaRepository<TCat, String> {
    TCat findById(Integer id);

    Set<TCat> searchByName(String name);
}