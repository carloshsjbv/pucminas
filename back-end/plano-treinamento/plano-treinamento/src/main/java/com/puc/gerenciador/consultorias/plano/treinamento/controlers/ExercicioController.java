package com.puc.gerenciador.consultorias.plano.treinamento.controlers;

import com.puc.gerenciador.consultorias.plano.treinamento.entity.EnumGrupoMuscular;
import com.puc.gerenciador.consultorias.plano.treinamento.entity.ExercicioEntity;
import com.puc.gerenciador.consultorias.plano.treinamento.model.request.ExercicioRequest;
import com.puc.gerenciador.consultorias.plano.treinamento.service.ExercicioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/exercicio")
public class ExercicioController {

    private final ExercicioService service;

    public ExercicioController(final ExercicioService service) {
        this.service = service;
    }

    @PostMapping
    public ExercicioEntity criarExercicio(@RequestBody final ExercicioRequest request) {
        return service.criarExercicio(request);
    }

    @GetMapping
    public List<ExercicioEntity> getExercicios(
            @RequestParam(required = false) @Valid EnumGrupoMuscular enumGrupoMuscular
    ) {
        return service.listarExercicios(enumGrupoMuscular);
    }

    @PatchMapping
    public ExercicioEntity getExercicios(@RequestParam final Long id, @RequestBody final ExercicioRequest requestBody) {
        return service.atualizarExercicio(id, requestBody);
    }

}
