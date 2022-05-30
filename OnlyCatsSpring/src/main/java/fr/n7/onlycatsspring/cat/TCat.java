package fr.n7.onlycatsspring.cat;

import fr.n7.onlycatsspring.account.TAccount;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_cat")
public class TCat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_account", nullable = false)
    private TAccount owner;

    @ManyToMany
    @JoinTable(name = "t_subscriptions", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "cat_id"))
    private Set<TAccount> subscribers;

    public void setSubscribers(Set<TAccount> subscribers) {
        this.subscribers = subscribers;
    }

    public Set<TAccount> getSubscribers() {
        return subscribers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public TAccount getOwner() {
        return owner;
    }

    public void setOwner(TAccount owner) {
        this.owner = owner;
    }

}