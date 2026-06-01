package com.crud.app.controller;

import com.crud.app.model.Producto;
import com.crud.app.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    /** Muestra el listado de productos junto con el formulario de registro. */
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("productos", productoService.listarTodos());
        model.addAttribute("producto", new Producto());
        return "productos/lista";
    }

    /** Procesa el formulario de registro y guarda el nuevo producto. */
    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("producto") Producto producto,
                          BindingResult result,
                          Model model,
                          RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("productos", productoService.listarTodos());
            return "productos/lista";
        }
        productoService.guardar(producto);
        redirectAttributes.addFlashAttribute("mensaje", "Producto registrado exitosamente.");
        return "redirect:/productos";
    }

    /** Elimina el producto identificado por el id recibido en la URL. */
    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        productoService.eliminar(id);
        redirectAttributes.addFlashAttribute("mensaje", "Producto eliminado exitosamente.");
        return "redirect:/productos";
    }
}
