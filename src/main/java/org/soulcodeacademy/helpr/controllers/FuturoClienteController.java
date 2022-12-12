package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.FuturoCliente;
import org.soulcodeacademy.helpr.domain.dto.FuturoClienteDTO;
import org.soulcodeacademy.helpr.services.FuturoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class FuturoClienteController {
    @RestController
    public class futuroClienteController {
        @Autowired
        private FuturoClienteService futuroClienteService;

        @GetMapping("/futuroCliente")
        private List<FuturoCliente> listar() {
            return this.futuroClienteService.listarTodos();
        }


        @GetMapping("/futuroCliente/email")
        public List<FuturoCliente> listarPorEmail(@RequestParam String email){
            return this.futuroClienteService.listarPorEmail(email);
        }

        @GetMapping("/futuroCliente/nome")
        private List<FuturoCliente> listarPorNome(@RequestParam String nome) {
            return futuroClienteService.listarPorNome(nome);
        }

        @PostMapping("/futuroCliente")
        public FuturoCliente salvar(@Valid @RequestBody FuturoClienteDTO dto) {
            FuturoCliente futuroCliente = this.futuroClienteService.salvar(dto);
            return futuroCliente;
        }

        @DeleteMapping("/futuroCliente/{idFuturoCliente}")
        private void deletar(@PathVariable Integer idFuturoCliente) {
            this.futuroClienteService.deletar(idFuturoCliente);
        }
    }
}
