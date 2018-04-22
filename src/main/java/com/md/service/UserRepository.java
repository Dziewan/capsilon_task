package com.md.service;

import com.md.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IStateRepository extends JpaRepository<User, Long> {
}
