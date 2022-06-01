package fr.n7.onlycatsspring.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import fr.n7.onlycatsspring.account.TAccount;
import fr.n7.onlycatsspring.post.TPost;

import javax.persistence.*;

@Entity
@Table(name = "t_comment")
public class TComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post", nullable = false)
    @JsonIgnore
    private TPost post;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_account", nullable = false)
    private TAccount account;

    @Lob
    @Column(name = "text", nullable = false)
    private String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TPost getPost() {
        return post;
    }

    public void setPost(TPost post) {
        this.post = post;
    }

    public TAccount getAccount() {
        return account;
    }

    public void setAccount(TAccount username) {
        this.account = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TComment{" +
                "id=" + id +
                ", post=" + post +
                ", account=" + account +
                ", text='" + text + '\'' +
                '}';
    }
}