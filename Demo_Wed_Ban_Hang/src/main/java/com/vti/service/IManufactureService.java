package com.vti.service;

import com.vti.entity.Manufacture;
import com.vti.form.CreatingManufactureForm;
import com.vti.form.UpdatingManufactureForm;
import java.util.List;

public interface IManufactureService {
    List<Manufacture> getAllManufacture();

    void createManufacture(CreatingManufactureForm form);

    void updateManufacture(UpdatingManufactureForm form);

    void deleteManufacture(int id);

    Manufacture getManufactureById(int id);

    boolean isManufactureExistsByName(String name);
}
