package io.github.marrafon91.crud.repository;

import io.github.marrafon91.crud.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
