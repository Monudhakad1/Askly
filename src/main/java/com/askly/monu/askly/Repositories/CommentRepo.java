package com.askly.monu.askly.Repositories;
import com.askly.monu.askly.models.Comments;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends JpaRepository<Comments, Long> {

    Page<Comments>findByAnswerId(Long answerId, Pageable pageable); // PAGABLE INTERFACE FOR PAGINATION (IN QUERY THERE IS lIMIT)

    Page<Comments> findByParentCommentId(Long parentCommentId,Pageable pageable);
}
