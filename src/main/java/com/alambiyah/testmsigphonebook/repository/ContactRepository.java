package com.alambiyah.testmsigphonebook.repository;

import com.alambiyah.testmsigphonebook.domain.Contact;
import com.alambiyah.testmsigphonebook.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Contact entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>, JpaSpecificationExecutor<Contact> {
    Optional<Contact> findOneByNumberIgnoreCase(String number);
}
