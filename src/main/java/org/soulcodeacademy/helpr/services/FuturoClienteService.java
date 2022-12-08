package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.FuturoCliente;
import org.soulcodeacademy.helpr.domain.dto.FuturoClienteDTO;
import org.soulcodeacademy.helpr.repositories.FuturoClienteRepository;
import org.soulcodeacademy.helpr.services.errors.ParametrosInsuficientesError;
import org.soulcodeacademy.helpr.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuturoClienteService {

    @Autowired
    private FuturoClienteRepository futuroClienteRepository;

    public List<FuturoCliente> listarTodos() {
        return this.futuroClienteRepository.findAll();
    }

    public List<FuturoCliente> listarPorCpf(String cpf) {
        return this.futuroClienteRepository.findByCpf(cpf);
    }

    public List<FuturoCliente> listarPorEmail(String email) {
        return this.futuroClienteRepository.findByCpf(email);
    }

    public FuturoCliente getFuturoCliente(Integer idFuturoCliente) {
        return this.futuroClienteRepository.findById(idFuturoCliente)
                .orElseThrow(() -> new RecursoNaoEncontradoError("Futuro cliente não encontrado"));
    }

    public FuturoCliente salvar(FuturoClienteDTO dto) {
        if(dto.getCpf()==null) {
            throw new ParametrosInsuficientesError(("Cpf nullo"));
        }
        FuturoCliente novoFuturoCliente = new FuturoCliente(null, dto.getNome(), dto.getTelefone(), dto.getEmail(), dto.getCpf());
        return this.futuroClienteRepository.save(novoFuturoCliente);
    }

    public void deletar(Integer idFuturoCliente) {
        FuturoCliente futuroCliente = this.getFuturoCliente(idFuturoCliente);
        this.futuroClienteRepository.delete(futuroCliente);
    }
}
