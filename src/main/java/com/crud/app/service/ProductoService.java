package com.crud.app.service;

import com.crud.app.model.Producto;
import com.crud.app.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    /** Retorna todos los productos registrados en la base de datos. */
    @Transactional(readOnly = true)
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    /** Persiste un nuevo producto en la base de datos. */
    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    /** Elimina el producto correspondiente al id proporcionado. */
    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }
}
