package fr.n7.onlycatsspring.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.n7.onlycatsspring.account.TAccount;
import fr.n7.onlycatsspring.cat.TCat;
import fr.n7.onlycatsspring.comment.TComment;
import fr.n7.onlycatsspring.like.TLike;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_post")
public class TPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_cat", nullable = false)
    private TCat cat;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_account", nullable = false)
    private TAccount account;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "post")
    private Set<TLike> likes;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "post")
    private Set<TComment> comments;

    @Lob
    @Column(name = "text", nullable = true)
    private String text;

    @Column(name = "image", nullable = true)
    private String image;

    @ManyToMany
    @JoinTable(name = "t_bookmarks", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "post_id"))
    private Set<TAccount> markers;

    public void setCat(TCat cat) {
        this.cat = cat;
    }

    public void setMarkers(Set<TAccount> markers) {
        this.markers = markers;
    }

    public Set<TAccount> getMarkers() {
        return markers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TCat getCat() {
        return cat;
    }

    public Set<TComment> getComments() {
        return comments;
    }

    public Set<TLike> getLikes() {
        return likes;
    }

    public void setComments(Set<TComment> comments) {
        this.comments = comments;
    }

    public void setLikes(Set<TLike> likes) {
        this.likes = likes;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "TPost{" +
                "id=" + id +
                ", cat=" + cat +
                ", account=" + account +
                ", text='" + text + '\'' +
                ", image='" + image + '\'' +
                ", markers=" + markers +
                '}';
    }
}