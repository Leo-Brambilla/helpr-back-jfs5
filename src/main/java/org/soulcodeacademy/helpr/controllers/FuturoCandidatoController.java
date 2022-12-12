package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.enums.Setor;
import org.soulcodeacademy.helpr.domain.FuturoCandidato;
import org.soulcodeacademy.helpr.domain.dto.FuturoCandidatoDTO;
import org.soulcodeacademy.helpr.services.FuturoCandidadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FuturoCandidatoController {
    @Autowired
    FuturoCandidadoService futuroCandidadoService;
    //GET -> Listar todos os CANDIDATOS a colaborador
    @GetMapping("/candidatos")
    public List<FuturoCandidato> listar() {
        return this.futuroCandidadoService.listar();
    }
    //GET -> Listar um CANDIDATO para colaborador por vez, usando IDcandidatoFuturo
    @GetMapping("/candidatos/{idCandidato}")
    public FuturoCandidato getCandidato(@PathVariable Integer idCandidato) {
        return this.futuroCandidadoService.getCandidato(idCandidato);
    }
    //GET -> Filtrar por NOME (o filtro esta no REPOSITORY)
    @GetMapping("/candidatos/nome")
    public List<FuturoCandidato> listarPorFaixaSalarial(@RequestParam String nome) {
        return this.futuroCandidadoService.listarPorNome(nome);
    }
    //GET -> Filtrar por SETOR (o filtro esta no REPOSITORY)
    @GetMapping("candidatos/setor")
    public List<FuturoCandidato> listarPorSetor(@RequestParam Setor setor){
        return this.futuroCandidadoService.listarPorSetor(setor);
    }
    //GET -> Filtrar por E-MAIL (o filtro esta no REPOSITORY)
    @GetMapping("candidatos/email")
    public List<FuturoCandidato> listarPorEmail(@RequestParam String email){
        return this.futuroCandidadoService.listarPorEmail(email);
    }
    //POST -> Salvar cada COLABORADOR (Futuro Candidato)
    @PostMapping("/candidatos")
    public FuturoCandidato salvar (@Valid @RequestBody FuturoCandidatoDTO dto){
        FuturoCandidato candidato = this.futuroCandidadoService.salvar(dto);
        return candidato;
    }
    //DELETE -> Deletar cada COLABORADOR (Futuro Candidato)
    @DeleteMapping("/candidatos/{idCandidato}")
    public void deletar(@PathVariable Integer idCandidato){
        this.futuroCandidadoService.deletar(idCandidato);
    }
}