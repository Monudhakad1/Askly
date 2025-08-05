package com.askly.monu.askly.Repositories;

import com.askly.monu.askly.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
