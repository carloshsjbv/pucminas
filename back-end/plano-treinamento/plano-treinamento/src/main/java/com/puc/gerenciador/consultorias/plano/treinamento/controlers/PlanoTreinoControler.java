package com.puc.gerenciador.consultorias.plano.treinamento.controlers;

import com.puc.gerenciador.consultorias.plano.treinamento.entity.PlanoTreinoEntity;
import com.puc.gerenciador.consultorias.plano.treinamento.model.request.PlanoTreinoRequest;
import com.puc.gerenciador.consultorias.plano.treinamento.service.PlanoTreinoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/plano-treino")
public class PlanoTreinoControler {

    private final PlanoTreinoService planoTreinoService;

    public PlanoTreinoControler(PlanoTreinoService planoTreinoService) {
        this.planoTreinoService = planoTreinoService;
    }


    @PostMapping
    public PlanoTreinoEntity inserirPlanoTreino(@RequestBody @Valid final PlanoTreinoRequest planoTreinoRequest) {
        return planoTreinoService.inserirPlanoTreino(planoTreinoRequest);
    }

    @GetMapping("/{id}")
    public PlanoTreinoEntity getPlanoTreino(@PathVariable("id") @Valid final Long id) {
        return planoTreinoService.getPlanoTreino(id);
    }


}
