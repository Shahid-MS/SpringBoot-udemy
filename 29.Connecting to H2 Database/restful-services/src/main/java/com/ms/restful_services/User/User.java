package com.ms.restful_services.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ms.restful_services.Post.Post;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "user_details")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Size(min = 2, message = "Name have atleast 2 characters")
  @JsonProperty("user_name")
  private String name;

  @Past(message = "Birth date should be past")
  private LocalDate birth;

  @OneToMany(mappedBy = "user")
  @JsonIgnore
  private List<Post> posts;

  public User() {}

  public User(int id, String name, LocalDate birth) {
    this.id = id;
    this.name = name;
    this.birth = birth;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getBirth() {
    return birth;
  }

  public void setBirth(LocalDate birth) {
    this.birth = birth;
  }

  public List<Post> getPosts() {
    return posts;
  }

  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", name=" + name + ", birth=" + birth + "]";
  }
}
