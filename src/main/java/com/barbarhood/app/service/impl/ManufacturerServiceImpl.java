package com.barbarhood.app.service.impl;

import com.barbarhood.app.dto.ManufacturerDTO;
import com.barbarhood.app.exception.BadRequestException;
import com.barbarhood.app.helper.EntityHelper;
import com.barbarhood.app.helper.PageUtils;
import com.barbarhood.app.mapper.ManufacturerMapper;
import com.barbarhood.app.model.Manufacturer;
import com.barbarhood.app.payload.request.BarbarhoodPageRequest;
import com.barbarhood.app.payload.request.ManufacturerPayload;
import com.barbarhood.app.repository.ManufacturerRepository;
import com.barbarhood.app.service.ManufacturerService;
import com.barbarhood.app.specifications.ManufacturerSpecification;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    public ManufacturerDTO createManufacturer(ManufacturerPayload manufacturerPayload) {
        Manufacturer manufacturer = Manufacturer
                .builder()
                .manufacturerName(manufacturerPayload.getManufacturerName())
                .build();
        return ManufacturerMapper.map(manufacturerRepository.save(manufacturer));
    }

    @Override
    public ManufacturerDTO updateManufacturer(ManufacturerPayload manufacturerPayload) {
        if (manufacturerPayload.getId() == null)
            throw new BadRequestException("Please provide a valid manufacturer id.");
        Manufacturer manufacturer = findManufacturerGivenId(manufacturerPayload.getId());
        manufacturer.setManufacturerName(EntityHelper.getNotNull(
                manufacturer.getManufacturerName(),
                manufacturerPayload.getManufacturerName()));
        return ManufacturerMapper.map(manufacturerRepository.save(manufacturer));
    }

    @Override
    public ManufacturerDTO findManufacturerById(Long manufacturerId) {
        return ManufacturerMapper.map(findManufacturerGivenId(manufacturerId));
    }

    @Override
    public Manufacturer findManufacturerGivenId(Long manufacturerId) {
        return manufacturerRepository
                .findById(manufacturerId)
                .orElseThrow(
                        () -> new BadRequestException("No manufacturer found with given id.")
                );
    }

    @Override
    public ManufacturerDTO deleteManufacturerById(Long manufacturerId) {
        Manufacturer manufacturer = findManufacturerGivenId(manufacturerId);
        manufacturer.setIsActive(Boolean.FALSE);
        return ManufacturerMapper.map(manufacturerRepository.save(manufacturer));
    }

    @Override
    public List<ManufacturerDTO> findAllManufacturers(
            BarbarhoodPageRequest filterAttributes) {
        Pageable pageable = PageUtils.createPageWithSort(filterAttributes);
        Page<Manufacturer> page = manufacturerRepository.findAll(
                ManufacturerSpecification.filter(filterAttributes),
                pageable);
        return page.map(ManufacturerMapper::map).getContent();
    }
}
