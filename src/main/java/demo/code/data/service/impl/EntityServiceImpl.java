package demo.code.data.service.impl;

import demo.code.business.dto.CompanyDto;
import demo.code.data.mapper.EntityMapper;
import demo.code.data.model.EntityType;
import demo.code.data.repository.EntityRepository;
import demo.code.data.service.EntityService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntityServiceImpl implements EntityService {

    private final EntityRepository entityRepository;

    public EntityServiceImpl(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    public Optional<CompanyDto> getCompanyByName(String name) {
        return EntityMapper.toCompanyDto(entityRepository.findByTypeAndName(EntityType.COMPANY, name));
    }

    public Optional<CompanyDto> getCompanyById(Long id) {
        return EntityMapper.toCompanyDto(entityRepository.findById(id));
    }

    public void saveEntity(CompanyDto companyDto) {
        entityRepository.save(EntityMapper.toEntityModel(companyDto));
    }
}
