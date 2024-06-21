package com.project.questapp.services;

import com.project.questapp.converters.PostConverter;
import com.project.questapp.entities.Post;
import com.project.questapp.entities.User;
import com.project.questapp.repos.PostRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
public class PostServiceTest {

    PostService postService;

    private PostRepository postRepository;
    private UserService userService;
    private PostConverter postConverter;

    @Before
    public void setUp() throws Exception {
        postRepository = Mockito.mock(PostRepository.class);
        userService = Mockito.mock(UserService.class);
        postConverter = Mockito.mock(PostConverter.class);

        postService = new PostService(postRepository, userService, postConverter);
    }

    @Test
    public void whenGetAllPostsThenReturnAllPosts() {
        // Given
        User user = new User();
        user.setId(1L);
        user.setUserName("username");
        user.setPassword("password");

        Post post1 = new Post();
        post1.setId(1L);
        post1.setTitle("title1");
        post1.setText("text1");
        post1.setUser(user);

        Post post2 = new Post();
        post2.setId(2L);
        post2.setTitle("title2");
        post2.setText("text2");
        post2.setUser(user);

        List<Post> allPosts = Arrays.asList(post1, post2);
        Mockito.when(postRepository.findAll()).thenReturn(allPosts);

        // When
        List<Post> result = postService.getAllPosts(Optional.empty());

        // Then
        assertEquals(allPosts, result);
    }

    @Test
    public void whenGetAllPostsByUserIdThenReturnUserPosts() {
        // Given
        User user = new User();
        user.setId(1L);
        user.setUserName("username");
        user.setPassword("password");

        Post post1 = new Post();
        post1.setId(1L);
        post1.setTitle("title1");
        post1.setText("text1");
        post1.setUser(user);

        List<Post> userPosts = Arrays.asList(post1);
        Mockito.when(postRepository.findByUserId(1L)).thenReturn(userPosts);

        // When
        List<Post> result = postService.getAllPosts(Optional.of(1L));

        // Then
        assertEquals(userPosts, result);
    }

}