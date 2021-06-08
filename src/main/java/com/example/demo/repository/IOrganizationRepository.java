package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Organization;

public interface IOrganizationRepository extends JpaRepository<Organization, Integer> {

}
