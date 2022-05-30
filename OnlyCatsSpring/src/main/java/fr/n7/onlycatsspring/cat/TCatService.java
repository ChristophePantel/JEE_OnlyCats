package fr.n7.onlycatsspring.cat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TCatService {

    public final TCatRepository cr;

    @Autowired
    public TCatService(TCatRepository cr) {
        this.cr = cr;
    }

    public void addCat(TCat newCat) {
        cr.save(newCat);
    }

}
