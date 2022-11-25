package com.data.tokoonline.service;

import com.data.tokoonline.exception.InternalErorException;
import com.data.tokoonline.exception.NotFoundException;
import com.data.tokoonline.model.Barang;
import com.data.tokoonline.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarangServicelmpl implements BarangService {

    @Autowired
    BarangRepository barangRepository;

    @Override
    public Barang addBarang(Barang barang) {
        try {
        return barangRepository.save(barang);
        }catch (Exception e){
            throw new InternalErorException("Data harus diisi semua");
        }
    }

    @Override
    public Object getBarangById(Long id) {
        return barangRepository.findById(id).orElseThrow(() -> new NotFoundException("Id tidak ditemukan"));
    }

    @Override
    public Object getAllBarang() {
         try {
        return barangRepository.findAll();
         }catch (Exception e) {
             return "Kesalahan memunculkan data";
         }
    }

    @Override
    public Object editBarangById(Long id, String name, float price, Integer count, Integer reting, String description, boolean publish) {
        Barang barang = barangRepository.findById(id).get();
        barang.setName(name);
        barang.setPrice(Float.valueOf(price));
        barang.setCount(Integer.valueOf(count));
        barang.setReting(Integer.valueOf(reting));
        barang.setDescription(description);
        barang.setPublish(Boolean.valueOf(publish));
        return barangRepository.save(barang);
    }

    @Override
    public void deleteBarangById(Long id) {
        barangRepository.deleteById(id);
    }
}
