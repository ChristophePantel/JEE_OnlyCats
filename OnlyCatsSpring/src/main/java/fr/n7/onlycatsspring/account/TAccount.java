package fr.n7.onlycatsspring.account;

import fr.n7.onlycatsspring.cat.TCat;
import fr.n7.onlycatsspring.post.TPost;

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

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany(mappedBy = "subscribers")
    private Set<TCat> subscribed_to_cats;

    @ManyToMany(mappedBy = "markers")
    private Set<TPost> bookmarks;

    public void setBookmarks(Set<TPost> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public Set<TPost> getBookmarks() {
        return bookmarks;
    }

    public Set<TCat> getSubscribed_to_cats() {
        return subscribed_to_cats;
    }

    public void setSubscribed_to_cats(Set<TCat> subscribed_to_cats) {
        this.subscribed_to_cats = subscribed_to_cats;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}