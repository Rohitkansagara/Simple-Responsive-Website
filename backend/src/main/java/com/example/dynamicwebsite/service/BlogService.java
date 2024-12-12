package com.example.dynamicwebsite.service;

import com.example.dynamicwebsite.model.Blog;
import com.example.dynamicwebsite.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    // Get all blogs
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    // Create a new blog
    public Blog createBlog(Blog newBlog) {
        return blogRepository.save(newBlog);
    }

    // Update an existing blog
    public Blog updateBlog(Long id, Blog updatedBlog) {
        Optional<Blog> optionalBlog = blogRepository.findById(id);
        if (optionalBlog.isPresent()) {
            Blog blog = optionalBlog.get();
            blog.setTitle(updatedBlog.getTitle());
            blog.setContent(updatedBlog.getContent());
            return blogRepository.save(blog);
        }
        return null;
    }

    // Delete a blog
    public boolean deleteBlog(Long id) {
        if (blogRepository.existsById(id)) {
            blogRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Get a single blog by ID
    public Blog getBlogById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }
}
