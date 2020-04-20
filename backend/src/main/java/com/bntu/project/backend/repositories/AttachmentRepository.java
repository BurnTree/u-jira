package com.bntu.project.backend.repositories;

import com.bntu.project.backend.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
}
