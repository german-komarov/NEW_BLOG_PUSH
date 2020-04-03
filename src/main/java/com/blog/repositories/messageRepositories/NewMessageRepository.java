package com.blog.repositories.messageRepositories;

import com.blog.entities.message.NewMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewMessageRepository extends JpaRepository<NewMessage,Long> {

}
