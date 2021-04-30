package com.barbarhood.app.mapper;

import com.barbarhood.app.dto.ManufacturerDTO;
import com.barbarhood.app.model.Manufacturer;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public interface ManufacturerMapper {

    static ManufacturerDTO map(Manufacturer manufacturer)
    {
        if (manufacturer == null)
            return null;
        return ManufacturerDTO
                .builder()
                .manufacturerId(manufacturer.getId())
                .manufacturerName(manufacturer.getManufacturerName())
                .build();
    }

    static List<ManufacturerDTO> map(List<Manufacturer> manufacturerList)
    {
        if (manufacturerList == null || manufacturerList.isEmpty())
            return Collections.emptyList();

        return manufacturerList
                .stream()
                .filter(Objects::nonNull)
                .map(ManufacturerMapper::map)
                .collect(Collectors.toList());
    }

}
