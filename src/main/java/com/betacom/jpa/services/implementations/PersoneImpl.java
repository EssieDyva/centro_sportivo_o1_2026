package com.betacom.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.inputs.PersoneReq;
import com.betacom.jpa.dto.outputs.PersoneDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.models.Persone;
import com.betacom.jpa.repositories.IPersoneRepository;
import com.betacom.jpa.services.interfaces.IPersoneServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class PersoneImpl implements IPersoneServices{

    private final IPersoneRepository perR;

    @Override
    public void create(PersoneReq req) throws Exception {
        log.debug("create {}", req);
        Persone p = new Persone();
        p.setNome(req.getNome());
        p.setCognome(req.getCognome());
        p.setEmail(req.getEmail());
        p.setColore(req.getColore());

        perR.save(p);
    }

    @Override
    public void update(PersoneReq req) throws Exception {
        log.debug("update {}", req);
        Persone p = perR.findById(req.getId())
            .orElseThrow(() -> new AcademyException("Persona non trovata"));

        if (req.getCognome() != null) p.setCognome(req.getCognome());
        if (req.getNome() != null) p.setNome(req.getNome());
        if (req.getEmail() != null) p.setEmail(req.getEmail());
        if (req.getColore() != null) p.setColore(req.getColore());

        perR.save(p);
    }

    @Override
    public void delete(Integer id) throws Exception {
        log.debug("delete {}", id);
        Persone p = perR.findById(id)
            .orElseThrow(() -> new AcademyException("Persona non trovata"));

        perR.delete(p);
    }

    @Override
    public List<PersoneDTO> list() {
        log.debug("list");
        List<Persone> lP = perR.findAll();

        return lP.stream()
            .map(p -> PersoneDTO.builder()
            .id(p.getId())
            .nome(p.getNome())
            .cognome(p.getCognome())
            .email(p.getEmail())
            .colore(p.getColore())
            .build()
        ).toList();
    }

    @Override
    public PersoneDTO getById(Integer id) throws Exception {
        log.debug("getById {}", id);

        Persone p = perR.findById(id)
            .orElseThrow(() -> new AcademyException("Persona non trovata"));

        return PersoneDTO.builder()
            .id(p.getId())
            .nome(p.getNome())
            .cognome(p.getCognome())
            .email(p.getEmail())
            .colore(p.getColore())
            .build();
    }

}
