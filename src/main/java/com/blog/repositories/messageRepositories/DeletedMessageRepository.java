package com.blog.repositories.messageRepositories;

import com.blog.entities.message.DeletedMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeletedMessageRepository extends JpaRepository<DeletedMessage,Long> {
}
