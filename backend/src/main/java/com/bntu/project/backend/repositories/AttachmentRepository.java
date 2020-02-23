package com.bntu.project.backend.repositories;

import com.bntu.project.backend.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
    List<Attachment> findAllByTask(int idTask);
}
