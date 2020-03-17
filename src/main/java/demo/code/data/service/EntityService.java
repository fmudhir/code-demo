package demo.code.data.service;

import demo.code.business.dto.CompanyDto;
import demo.code.data.mapper.EntityMapper;
import demo.code.data.model.EntityType;
import demo.code.data.repository.EntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntityService {
    private final EntityRepository entityRepository;

    public EntityService(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    public Optional<CompanyDto> getCompanyByName(String name) {
        return EntityMapper.toCompanyDto(entityRepository.findByTypeAndName(EntityType.COMPANY, name));
    }
    public List<CompanyDto> getEntities() {
        return EntityMapper.toCompanyDtos(entityRepository.findAll());
    }

    public void saveEntity(CompanyDto companyDto) {
        entityRepository.save(EntityMapper.toEntityModel(companyDto));
    }
}
