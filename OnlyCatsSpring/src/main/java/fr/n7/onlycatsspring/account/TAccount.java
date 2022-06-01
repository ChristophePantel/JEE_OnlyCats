package fr.n7.onlycatsspring.account;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import fr.n7.onlycatsspring.bookmark.TBookmark;
import fr.n7.onlycatsspring.cat.TCat;
import fr.n7.onlycatsspring.post.TPost;
import fr.n7.onlycatsspring.subscriptions.TSubscription;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_account")
public class TAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
    private Set<TCat> cats;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "account")
    private Set<TSubscription> subs;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "account")
    private Set<TBookmark> bookmarks;

    public Set<TCat> getCats() {
        return cats;
    }

    public void setCats(Set<TCat> cats) {
        this.cats = cats;
    }

    public void setBookmarks(Set<TBookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public Set<TBookmark> getBookmarks() {
        return bookmarks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Set<TSubscription> getSubs() {
        return subs;
    }

    public void setSubs(Set<TSubscription> subs) {
        this.subs = subs;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "TAccount{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}