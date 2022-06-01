package fr.n7.onlycatsspring.subscriptions;

import fr.n7.onlycatsspring.account.TAccount;
import fr.n7.onlycatsspring.cat.TCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TSubscriptionService {
    public final TSubscriptionRepository sr;

    @Autowired
    public TSubscriptionService(TSubscriptionRepository sr) {
        this.sr = sr;
    }

    public TSubscription createTSub(TCat cat, TAccount account) {
        TSubscription sub = new TSubscription();
        sub.setAccount(account);
        sub.setCat(cat);
        return sr.save(sub);
    }

    public void deleteSub(Integer accountId, Integer catId) {
        TSubscription sub = sr.findByAccountIdAndCatId(accountId, catId);
        sr.delete(sub);
    }
}
