package com.blog.repositories;

import com.blog.entities.DefaultAvatar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefaultAvatarRepository extends JpaRepository<DefaultAvatar,Long> {

    DefaultAvatar findByColorOfPhoto(String color);
}
