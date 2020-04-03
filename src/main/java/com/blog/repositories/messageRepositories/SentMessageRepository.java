package com.blog.repositories.messageRepositories;

import com.blog.entities.message.SentMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SentMessageRepository  extends JpaRepository<SentMessage,Long> {
}
