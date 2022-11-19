package com.preact.SpringBootSandbox.unittesting.repository;


import com.preact.SpringBootSandbox.unittesting.modal.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitTestItemRepository extends JpaRepository<Item,Long> {
}
