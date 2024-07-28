package com.alambiyah.testmsigphonebook.web.rest;

import com.alambiyah.testmsigphonebook.repository.ContactRepository;
import com.alambiyah.testmsigphonebook.service.ContactQueryService;
import com.alambiyah.testmsigphonebook.service.ContactService;
import com.alambiyah.testmsigphonebook.service.criteria.ContactCriteria;
import com.alambiyah.testmsigphonebook.service.dto.ContactDTO;
import com.alambiyah.testmsigphonebook.web.rest.errors.BadRequestAlertException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.alambiyah.testmsigphonebook.domain.Contact}.
 */
@RestController
@RequestMapping("/api/contacts")
public class ContactResource {

    private static final Logger log = LoggerFactory.getLogger(ContactResource.class);

    private static final String ENTITY_NAME = "contact";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ContactService contactService;

    private final ContactRepository contactRepository;

    private final ContactQueryService contactQueryService;

    public ContactResource(ContactService contactService, ContactRepository contactRepository, ContactQueryService contactQueryService) {
        this.contactService = contactService;
        this.contactRepository = contactRepository;
        this.contactQueryService = contactQueryService;
    }

    /**
     * {@code POST  /contacts} : Create a new contact.
     *
     * @param contactDTO the contactDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new contactDTO, or with status {@code 400 (Bad Request)} if the contact has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<ContactDTO> createContact(@Valid @RequestBody ContactDTO contactDTO) throws URISyntaxException {
        log.debug("REST request to save Contact : {}", contactDTO);
        if (contactDTO.getId() != null) {
            throw new BadRequestAlertException("A new contact cannot already have an ID", ENTITY_NAME, "idexists");
        }
        contactDTO = contactService.save(contactDTO);
        return ResponseEntity.created(new URI("/api/contacts/" + contactDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, contactDTO.getId().toString()))
            .body(contactDTO);
    }

    /**
     * {@code PUT  /contacts/:id} : Updates an existing contact.
     *
     * @param id the id of the contactDTO to save.
     * @param contactDTO the contactDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated contactDTO,
     * or with status {@code 400 (Bad Request)} if the contactDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the contactDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ContactDTO> updateContact(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody ContactDTO contactDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Contact : {}, {}", id, contactDTO);
        if (contactDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, contactDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!contactRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        contactDTO = contactService.update(contactDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, contactDTO.getId().toString()))
            .body(contactDTO);
    }

    /**
     * {@code PATCH  /contacts/:id} : Partial updates given fields of an existing contact, field will ignore if it is null
     *
     * @param id the id of the contactDTO to save.
     * @param contactDTO the contactDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated contactDTO,
     * or with status {@code 400 (Bad Request)} if the contactDTO is not valid,
     * or with status {@code 404 (Not Found)} if the contactDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the contactDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ContactDTO> partialUpdateContact(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody ContactDTO contactDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Contact partially : {}, {}", id, contactDTO);
        if (contactDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, contactDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!contactRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ContactDTO> result = contactService.partialUpdate(contactDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, contactDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /contacts} : get all the contacts.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of contacts in body.
     */
    @GetMapping("")
    public ResponseEntity<List<ContactDTO>> getAllContacts(
        ContactCriteria criteria,
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get Contacts by criteria: {}", criteria);

        Page<ContactDTO> page = contactQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /contacts/count} : count all the contacts.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/count")
    public ResponseEntity<Long> countContacts(ContactCriteria criteria) {
        log.debug("REST request to count Contacts by criteria: {}", criteria);
        return ResponseEntity.ok().body(contactQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /contacts/:id} : get the "id" contact.
     *
     * @param id the id of the contactDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the contactDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ContactDTO> getContact(@PathVariable("id") Long id) {
        log.debug("REST request to get Contact : {}", id);
        Optional<ContactDTO> contactDTO = contactService.findOne(id);
        return ResponseUtil.wrapOrNotFound(contactDTO);
    }

    /**
     * {@code DELETE  /contacts/:id} : delete the "id" contact.
     *
     * @param id the id of the contactDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable("id") Long id) {
        log.debug("REST request to delete Contact : {}", id);
        contactService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}