package fr.n7.onlycatsspring.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TAccountService {

    public final TAccountRepository ar;

    @Autowired
    public TAccountService(TAccountRepository ar) {
        this.ar = ar;
    }

    public void addAccount(TAccount newAccount) {
        ar.save(newAccount);
    }

}
