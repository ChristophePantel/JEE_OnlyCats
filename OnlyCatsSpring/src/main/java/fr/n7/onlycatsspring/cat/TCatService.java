package fr.n7.onlycatsspring.cat;

import fr.n7.onlycatsspring.account.TAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TCatService {

    public final TCatRepository cr;

    @Autowired
    public TCatService(TCatRepository cr) {
        this.cr = cr;
    }

    public TCat getById(Integer id) {
        return cr.findById(id);
    }

    public TCat addCat(TCat newCat) {
        return cr.save(newCat);
    }

    public Set<TCat> searchByName(String name) {
        return cr.searchByName(name);
    }
}
