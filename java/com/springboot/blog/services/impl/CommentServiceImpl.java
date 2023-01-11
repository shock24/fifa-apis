package com.springboot.blog.services.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.blog.entities.Comment;
import com.springboot.blog.entities.Post;
import com.springboot.blog.exceptions.ResourceNotFoundException;
import com.springboot.blog.payloads.CommentDto;
import com.springboot.blog.repositories.CommentRepo;
import com.springboot.blog.repositories.PostRepo;
import com.springboot.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "post Id", postId));
		Comment comment =this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment saveComment = this.commentRepo.save(comment);
		return this.modelMapper.map(saveComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment com = this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "comment id", commentId));
		this.commentRepo.delete(com);
	}

}
