package com.askly.monu.askly.Repositories;

import com.askly.monu.askly.models.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Questions, Long> {

}