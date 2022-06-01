package fr.n7.onlycatsspring.like;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.n7.onlycatsspring.account.TAccount;
import fr.n7.onlycatsspring.post.TPost;

import javax.persistence.*;

@Entity
@Table(name = "t_like")
public class TLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_account", nullable = false)
    private TAccount account;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_post", nullable = false)
    @JsonIgnore
    private TPost post;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TAccount getAccount() {
        return account;
    }

    public void setAccount(TAccount username) {
        this.account = username;
    }

    public TPost getPost() {
        return post;
    }

    public void setPost(TPost post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "TLike{" +
                "id=" + id +
                ", account=" + account +
                ", post=" + post +
                '}';
    }
}