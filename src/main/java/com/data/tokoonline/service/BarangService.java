package com.data.tokoonline.service;

import com.data.tokoonline.model.Barang;

public interface BarangService {
    Barang addBarang (Barang barang);

    Object getBarangById (Long id);

    Object getAllBarang();

    void deleteBarangById(Long Id);

    Object editBarangById(Long id, String name, float price, Integer count, Integer reting, String description,  boolean publish);
}
