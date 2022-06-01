package fr.n7.onlycatsspring.cat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import fr.n7.onlycatsspring.account.TAccount;
import fr.n7.onlycatsspring.post.TPost;

import javax.persistence.*;
import java.util.LinkedHashSet;
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

    @Column(name = "image", nullable = true)
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    @JsonIgnore
    private TAccount owner;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<TPost> posts;



    public Set<TPost> getPosts() {
        return posts;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPosts(Set<TPost> posts) {
        this.posts = posts;
    }

    public Integer getId() {
        return id;
    }

    public void setOwner(TAccount owner) {
        this.owner = owner;
    }

    public TAccount getOwner() {
        return owner;
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

    @Override
    public String toString() {
        return "TCat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", posts=" + posts +
                '}';
    }
}