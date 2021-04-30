package com.barbarhood.app.service;

import com.barbarhood.app.dto.ManufacturerDTO;
import com.barbarhood.app.model.Manufacturer;
import com.barbarhood.app.payload.request.BarbarhoodPageRequest;
import com.barbarhood.app.payload.request.ManufacturerPayload;
import java.util.List;

public interface ManufacturerService {
    ManufacturerDTO createManufacturer(ManufacturerPayload manufacturerPayload);
    ManufacturerDTO updateManufacturer(ManufacturerPayload manufacturerPayload);
    ManufacturerDTO findManufacturerById(Long manufacturerId);
    Manufacturer findManufacturerGivenId(Long manufacturerId);
    ManufacturerDTO deleteManufacturerById(Long manufacturerId);
    List<ManufacturerDTO> findAllManufacturers(BarbarhoodPageRequest filterAttributes);
}
