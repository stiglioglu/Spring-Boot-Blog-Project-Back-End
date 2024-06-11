package com.project.questapp.converters;

import com.project.questapp.entities.Post;
import com.project.questapp.entities.User;
import com.project.questapp.requests.PostCreateRequest;
import com.project.questapp.requests.PostUpdateRequest;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {

    public PostConverter() {
    }

    public Post convertToPost(PostCreateRequest postCreateRequest, User user){
        Post post = new Post();
        post.setId(postCreateRequest.getId());
        post.setText(postCreateRequest.getText());
        post.setTitle(postCreateRequest.getTitle());
        post.setUser(user);
        return post;
    }

    public Post convertToPost(Post post, PostUpdateRequest postUpdateRequest) {
        post.setText(postUpdateRequest.getText());
        post.setTitle(postUpdateRequest.getTitle());
        return post;
    }

}
