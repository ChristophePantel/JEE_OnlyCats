package fr.n7.onlycatsspring.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service
public class TAccountService {

    public final TAccountRepository ar;

    @Autowired
    public TAccountService(TAccountRepository ar) {
        this.ar = ar;
    }

    public TAccount addAccount(TAccount newAccount) {
        return ar.save(newAccount);
    }

    public TAccount findByEmailAndPassword(String email, String password) {
        return ar.findByEmailAndPassword(email, password) ;
    }

    public TAccount findById(Integer id) {
        return ar.findById(id);
    }

}
