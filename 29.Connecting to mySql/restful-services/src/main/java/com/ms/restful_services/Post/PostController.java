package com.ms.restful_services.Post;

import com.ms.restful_services.User.User;
import com.ms.restful_services.User.UserNotFoundException;
import com.ms.restful_services.User.UserRepo;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class PostController {

  @Autowired
  private UserRepo userRepo;

  @Autowired
  private PostRepo postRepo;

  @GetMapping("/users/{id}/posts")
  public List<Post> getAllPostsByUser(@PathVariable int id) {
    User user = userRepo.findById(id).get();
    if (user == null) {
      throw new UserNotFoundException("User not found with id: " + id);
    }

    return user.getPosts();
  }

  @GetMapping("/users/{userId}/posts/{postId}")
  public Post getUser(@PathVariable int userId, @PathVariable int postId) {
    User user = userRepo.findById(userId).get();
    if (user == null) {
      throw new UserNotFoundException("User not found with id: " + userId);
    }

    return postRepo.findById(postId).get();
  }

  @PostMapping("/users/{id}/posts")
  public ResponseEntity<Post> createNewPost(
    @PathVariable int id,
    @Valid @RequestBody Post post
  ) {
    User user = userRepo.findById(id).get();
    if (user == null) {
      throw new UserNotFoundException("User not found with id: " + id);
    }
    post.setUser(user);
    Post savedPost = postRepo.save(post);
    URI location = ServletUriComponentsBuilder
      .fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(savedPost.getId())
      .toUri();
    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("/users/{userId}/posts/{postId}")
  public void deleteUser(@PathVariable int userId, @PathVariable int postId) {
    User user = userRepo.findById(userId).get();
    if (user == null) {
      throw new UserNotFoundException("User not found with id: " + userId);
    }
    postRepo.deleteById(postId);
  }
}
