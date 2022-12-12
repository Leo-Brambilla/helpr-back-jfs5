package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.FuturoCandidato;
import org.soulcodeacademy.helpr.domain.FuturoCandidatoDTO;
import org.soulcodeacademy.helpr.domain.enums.Setor;
import org.soulcodeacademy.helpr.repositories.FuturoCandidatoRepository;
import org.soulcodeacademy.helpr.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuturoCandidadoService {
    @Autowired
    FuturoCandidatoRepository futuroCandidatoRepository;
    //GET -> Listar todos os CANDIDATOS que desejam ser contratados como colaborador
    public List<FuturoCandidato> listar(){
        return this.futuroCandidatoRepository.findAll();
    }

    //GET -> Listar um CANDIDATO Um Por Um, usando ID da lista dos futuroCandidato
    public FuturoCandidato getCandidato(Integer idCandidato) {
        return  this.futuroCandidatoRepository.findById(idCandidato)
                .orElseThrow(() -> new RecursoNaoEncontradoError("Não foi possível achar esse candidato."));
    }

    //GET -> Filtrar por NOME
    public List<FuturoCandidato> listarPorNome(String nome) {
        return this.futuroCandidatoRepository.findByNomeCompletoContaining(nome);
    }

    //GET -> Filtrar pelo SETOR
    public List<FuturoCandidato>listarPorSetor(Setor setor){
        return this.futuroCandidatoRepository.findBySetor(setor);
    }
    //GET -> Filtrar por E-MAIL (o filtro esta no REPOSITORY)
    public  List<FuturoCandidato>listarPorEmail(String email){
        return this.futuroCandidatoRepository.findByEmail(email);
    }

    //POST -> Salvar cada COLABORADOR (Futuro Candidato)
    public FuturoCandidato salvar (FuturoCandidatoDTO dto ){
        FuturoCandidato newCandidato = new FuturoCandidato(null, dto.getNomeCompleto(), dto.getEmail(), dto.getDescricaoHabilidades());
        newCandidato.setSetor(dto.getSetor());
        return  this.futuroCandidatoRepository.save(newCandidato);
    }

    //DELETE -> Deletar cada COLABORADOR (Futuro Candidato)
    public void deletar(Integer idFuncionario) {
        FuturoCandidato candidato = this.getCandidato(idFuncionario);
        try {
            this.futuroCandidatoRepository.delete(candidato);
        } catch (org.springframework.dao.DataIntegrityViolationException error){
            throw new DataIntegrityViolationException("Impossível prosseguir nessa operação: DELETE!");
        }
    }
}
