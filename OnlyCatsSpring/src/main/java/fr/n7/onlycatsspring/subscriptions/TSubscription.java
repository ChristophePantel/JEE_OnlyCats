package fr.n7.onlycatsspring.subscriptions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.n7.onlycatsspring.account.TAccount;
import fr.n7.onlycatsspring.cat.TCat;

import javax.persistence.*;

@Entity
@Table(name = "t_subscription")
public class TSubscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_account", nullable = false)
    @JsonIgnore
    private TAccount account;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_cat", nullable = false)
    private TCat cat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TAccount getAccount() {
        return account;
    }

    public void setAccount(TAccount account) {
        this.account = account;
    }

    public TCat getCat() {
        return cat;
    }

    public void setCat(TCat cat) {
        this.cat = cat;
    }
}