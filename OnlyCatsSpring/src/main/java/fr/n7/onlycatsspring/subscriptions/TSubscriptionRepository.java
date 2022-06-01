package fr.n7.onlycatsspring.subscriptions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TSubscriptionRepository extends JpaRepository<TSubscription, Long> {
    TSubscription findByAccountIdAndCatId(Integer account_id, Integer cat_id);
}