package fr.n7.onlycatsspring.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TAccountRepository extends JpaRepository<TAccount, String> {
    TAccount findByEmailAndPassword(String email, String password);

    public TAccount findById(Integer id);
}