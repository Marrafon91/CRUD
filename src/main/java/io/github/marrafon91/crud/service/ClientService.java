package io.github.marrafon91.crud.service;

import io.github.marrafon91.crud.dto.ClientDTO;
import io.github.marrafon91.crud.entity.Client;
import io.github.marrafon91.crud.repository.ClientRepository;
import io.github.marrafon91.crud.service.exceptions.DatabaseException;
import io.github.marrafon91.crud.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = repository.findAll(pageable);
        return result.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insert (ClientDTO dto) {
        Client client = new Client();
        dtoToEntity(dto, client);
        client = repository.save(client);
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO update (Long id, ClientDTO dto) {
        try {
            Client entity = repository.getReferenceById(id);
            dtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ClientDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Cliente não encontrado!");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente não encontrado!");
        }
        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação de integridade referencial!");
        }
    }


    private void dtoToEntity(ClientDTO dto, Client client) {
        client.setName(dto.name());
        client.setCpf(dto.cpf());
        client.setIncome(dto.income());
        client.setBirthDate(dto.birthDate());
        client.setChildren(dto.children());
    }
}
