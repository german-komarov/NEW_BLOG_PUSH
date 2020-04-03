package com.blog.repositories.messageRepositories;

import com.blog.entities.message.CheckedMessage;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CheckedMessageRepository extends JpaRepository<CheckedMessage,Long> {
}
