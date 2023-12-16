package com.vti.controller;

import com.vti.dto.ManufactureDTO;
import com.vti.form.CreatingManufactureForm;
import com.vti.form.UpdatingManufactureForm;
import com.vti.service.IManufactureService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/manufactures")
@CrossOrigin("*")
public class ManufactureController {

    @Autowired
    private IManufactureService manufactureService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ManufactureDTO>> getAllManufacture() {
        List<ManufactureDTO> ls = modelMapper.map(manufactureService.getAllManufacture(), new TypeToken<List<ManufactureDTO>>() {
        }.getType());
        return new ResponseEntity<>(ls, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createManufacture(@RequestBody CreatingManufactureForm form) {
        manufactureService.createManufacture(form);
        return new ResponseEntity<>("Tao manufacture thanh cong", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateManufacture(@PathVariable(name = "id") int id, @RequestBody UpdatingManufactureForm form) {
        form.setId(id);
        manufactureService.updateManufacture(form);
        return new ResponseEntity<>("update manufacture thanh cong",HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteManufacture(@PathVariable(name = "id") int id) {
        manufactureService.deleteManufacture(id);
        return new ResponseEntity<>("delete manufacture thanh cong",HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ManufactureDTO> getManufactureById(@PathVariable(name = "id") int id){
        return new ResponseEntity<>(modelMapper.map(manufactureService.getManufactureById(id), ManufactureDTO.class), HttpStatus.OK);
    }
}
