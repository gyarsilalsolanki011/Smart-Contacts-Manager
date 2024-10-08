package com.gsl.scm.repositories;

import com.gsl.scm.entities.Contact;
import com.gsl.scm.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {
    Page<Contact> findByUser(User user, Pageable pageable);

    @Query("SELECT c FROM Contact c where c.user.userId = :userId")
    List<Contact> findByUserId(@Param("userId") String userId);

    Page<Contact> findByUserAndNameContaining(User user, String nameKeyword, Pageable pageable);

    Page<Contact> findByUserAndEmailContaining(User user, String emailKeyword, Pageable pageable);

    Page<Contact> findByUserAndPhoneNumberContaining(User user, String phoneKeyword, Pageable pageable);
}
