package com.example.sprint.controller;

import com.example.sprint.dto.CidadeDTO;
import com.example.sprint.form.AtualizacaoCidadeForm;
import com.example.sprint.form.CidadeForm;
import com.example.sprint.modelo.Cidade;
import com.example.sprint.modelo.Regiao;
import com.example.sprint.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/states")
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping
    public Page<CidadeDTO> lista(@RequestParam(required = false) Regiao nomeRegiao,
                                 @RequestParam int pag, @RequestParam int qtd, @RequestParam String ordenacao) {

        Pageable paginacao = PageRequest.of(pag, qtd, Sort.Direction.DESC, ordenacao);

        if(nomeRegiao == null){
            Page<Cidade> cidades = cidadeRepository.findAll(paginacao);
            return CidadeDTO.converter(cidades);
        }else{
            Page<Cidade> cidades = cidadeRepository.findByRegiao(nomeRegiao, paginacao);
            return CidadeDTO.converter(cidades);
        }
    }
    @PostMapping
    public ResponseEntity<CidadeDTO> cadastrar(@RequestBody @Valid CidadeForm form, UriComponentsBuilder uriBuilder){
        Cidade cidade = form.converter(cidadeRepository);

        URI uri = uriBuilder.path("/api/states/{id}").buildAndExpand(cidade.getId()).toUri();
        return ResponseEntity.created(uri).body(new CidadeDTO(cidade));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CidadeDTO> detalhar(@PathVariable Long id){
        Optional<Cidade> cidade = cidadeRepository.findById(id);
        if(cidade.isPresent()){
            return ResponseEntity.ok(new CidadeDTO(cidade.get()));
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CidadeDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoCidadeForm form){
        Optional<Cidade> optional = cidadeRepository.findById(id);
        if(optional.isPresent()){
            Cidade cidade = form.atualizar(id, cidadeRepository);
            return ResponseEntity.ok(new CidadeDTO(cidade));
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Cidade> cidade = cidadeRepository.findById(id);
        if (cidade.isPresent()) {
            cidadeRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
