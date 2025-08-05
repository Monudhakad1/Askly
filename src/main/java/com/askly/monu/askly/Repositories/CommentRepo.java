package com.askly.monu.askly.Repositories;

import com.askly.monu.askly.models.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comments, Long> {

}
