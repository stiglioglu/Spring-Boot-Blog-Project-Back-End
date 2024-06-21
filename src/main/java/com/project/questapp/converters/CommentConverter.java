package com.project.questapp.converters;

import com.project.questapp.entities.Comment;
import com.project.questapp.entities.Post;
import com.project.questapp.entities.User;
import com.project.questapp.requests.CommentCreateRequest;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {

    public CommentConverter() {
    }

    public Comment convertToComment(CommentCreateRequest request, User user, Post post){
        Comment commentToSave = new Comment();
        commentToSave.setId(request.getId());
        commentToSave.setPost(post);
        commentToSave.setUser(user);
        commentToSave.setText(request.getText());
        return commentToSave;
    }

}
