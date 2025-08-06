package com.askly.monu.askly.Repositories;

import com.askly.monu.askly.models.Questions;
import com.askly.monu.askly.models.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface QuestionRepo extends JpaRepository<Questions, Long> {

    @Query("SELECT q FROM Questions q JOIN q.tags t WHERE t.id IN :tagIds")
    Page<Questions> findQuestionsByTags(Set<Long> tagIds, Pageable pageable);
}