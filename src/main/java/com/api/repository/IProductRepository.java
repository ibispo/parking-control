package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.ProductModel;

public interface IProductRepository extends JpaRepository<ProductModel, Long> {

}
