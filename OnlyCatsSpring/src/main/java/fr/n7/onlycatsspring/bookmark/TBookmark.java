package fr.n7.onlycatsspring.bookmark;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.n7.onlycatsspring.account.TAccount;
import fr.n7.onlycatsspring.post.TPost;

import javax.persistence.*;

@Entity
@Table(name = "t_bookmarks")
public class TBookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    @JsonIgnore
    private TAccount account;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    @JsonIgnore
    private TPost post;

    public Integer getId() {
        return id;
    }

    public TAccount getAccount() {
        return account;
    }

    public TPost getPost() {
        return post;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAccount(TAccount account) {
        this.account = account;
    }

    public void setPost(TPost post) {
        this.post = post;
    }
}