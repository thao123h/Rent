package com.he187184.mvc.rent.repository;

import com.he187184.mvc.rent.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    Item findById(int id);
}
