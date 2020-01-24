package br.com.fiap.cervejaria.Controller;


import br.com.fiap.cervejaria.CervejaDTO;
import br.com.fiap.cervejaria.CreateCervejaDTO;
import br.com.fiap.cervejaria.Tipo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.fiap.cervejaria.Tipo.PILSEN;
import static br.com.fiap.cervejaria.Tipo.WEISS;

@RestController
@RequestMapping("cervejas")
public class CervejariaController {

    private List<CervejaDTO> cervejaDTOList;

    public CervejariaController(){
        cervejaDTOList = new ArrayList<>();
        cervejaDTOList.add(new CervejaDTO(1, "marca", 4.5,
                PILSEN, BigDecimal.valueOf(4.5), ZonedDateTime.now().minusYears(4)));

    }


    @GetMapping
    public List<CervejaDTO> getAll(@RequestParam(required = false) Tipo tipo){
        return cervejaDTOList.stream()
                .filter(cervejaDTO -> tipo == null || cervejaDTO.getTipo().equals(tipo) )
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public CervejaDTO findById(@PathVariable Integer id)
    {
        return cervejaDTOList.stream().filter(cervejaDTO ->  cervejaDTO.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CervejaDTO create(@RequestBody @Valid CreateCervejaDTO createCervejaDTO){
      CervejaDTO cervejaDTO =   new CervejaDTO(createCervejaDTO, cervejaDTOList.size() + 1);
      cervejaDTOList.add(cervejaDTO);
      return  cervejaDTO;
    }

    @PutMapping("{id}")
    public CervejaDTO update(@PathVariable Integer id, @RequestBody CreateCervejaDTO createCervejaDTO){
        CervejaDTO cervejaDTO = findById(id);
        cervejaDTO.setMarca(createCervejaDTO.getMarca());
        cervejaDTO.setPreco(createCervejaDTO.getPreco());
        cervejaDTO.setTeorAlcoolico(createCervejaDTO.getTeorAlcoolico());
        cervejaDTO.setDataLancamento(createCervejaDTO.getDataLancamento());
        cervejaDTO.setTipo(createCervejaDTO.getTipo());
        return cervejaDTO;
    }

    @PatchMapping("{id}")
    public CervejaDTO update(@PathVariable Integer id, @RequestBody PrecoCervejaDTO precoCervejaDTO)
    {
        CervejaDTO cervejaDTO = findById(id);
        cervejaDTO.setPreco(precoCervejaDTO.getPreco());
        return cervejaDTO;
    }

    @DeleteMapping
    public void delete(@PathVariable Integer id)
    {
        CervejaDTO cervejaDTO = findById(id);
        cervejaDTOList.remove(cervejaDTO);
    }






}
