package com.data.tokoonline.controller;

import com.data.tokoonline.model.Barang;
import com.data.tokoonline.response.ResponseHelper;
import com.data.tokoonline.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/barang")
public class BarangController {

    @Autowired
    private BarangService barangService;

    @GetMapping("/all")
    public Object getAllBarang() {
        return ResponseHelper.ok(barangService.getAllBarang());
    }

    @GetMapping("/{id}")
    public Object GetBarangById(@PathVariable("id")Long id) {
        return ResponseHelper.ok(barangService.getBarangById(id));
    }

    @PostMapping
    public Object addBarang(@RequestBody Barang barang) {
        return ResponseHelper.ok(barangService.addBarang(barang));
    }

    @PutMapping("/{id}")
    public Object editBarangById(@PathVariable("id") Long id, @RequestBody Barang barang) {
        return ResponseHelper.ok(barangService.editBarangById(id,barang.getName(),barang.getPrice(),barang.getCount(),barang.getReting(),barang.getDescription(),barang.isPublish()));
    }

    @DeleteMapping("/{id}")
    public void deleteBarangById(@PathVariable("id") Long id) { barangService.deleteBarangById(id);}
}
