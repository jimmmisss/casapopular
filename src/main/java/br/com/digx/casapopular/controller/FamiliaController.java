package br.com.digx.casapopular.controller;

import java.util.List;

import br.com.digx.casapopular.dto.FamiliaDto;
import br.com.digx.casapopular.service.FamiliaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "API REST Familias")
@RestController
@RequestMapping("/v1")
public class FamiliaController {

    private final FamiliaService familiaService;

    @Autowired
    public FamiliaController(FamiliaService familiaService) {
        this.familiaService = familiaService;
    }

    @ApiOperation(value = "Retorna uma lista de familias")
    @GetMapping("/familias")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<FamiliaDto> listar() {
        return familiaService.listar();
    }

    @ApiOperation(value = "Salva uma familia")
    @PostMapping("/familia")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@Validated @RequestBody FamiliaDto familiaDto) {
        familiaService.salvar(familiaDto);
    }

    @ApiOperation(value = "Altera uma familia")
    @PutMapping("/alterar-familia/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void alterar(@RequestBody FamiliaDto familiaDto, @PathVariable Long id) {
        familiaService.atualizar(familiaDto, id);
    }

    @ApiOperation(value = "Deleta uma familia")
    @DeleteMapping("/deletar-familia/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        familiaService.deletar(id);
    }

}
