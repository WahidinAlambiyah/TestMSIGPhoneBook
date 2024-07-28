package com.alambiyah.testmsigphonebook.service;

import com.alambiyah.testmsigphonebook.service.dto.ContactDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.alambiyah.testmsigphonebook.domain.Contact}.
 */
public interface ContactService {
    /**
     * Save a contact.
     *
     * @param contactDTO the entity to save.
     * @return the persisted entity.
     */
    ContactDTO save(ContactDTO contactDTO);

    /**
     * Updates a contact.
     *
     * @param contactDTO the entity to update.
     * @return the persisted entity.
     */
    ContactDTO update(ContactDTO contactDTO);

    /**
     * Partially updates a contact.
     *
     * @param contactDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ContactDTO> partialUpdate(ContactDTO contactDTO);

    /**
     * Get the "id" contact.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ContactDTO> findOne(Long id);

    /**
     * Delete the "id" contact.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
