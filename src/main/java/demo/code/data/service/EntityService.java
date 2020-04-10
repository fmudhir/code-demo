package demo.code.data.service;

import demo.code.business.dto.CompanyDto;

import java.util.Optional;

public interface EntityService {
    Optional<CompanyDto> getCompanyByName(String name);
    Optional<CompanyDto> getCompanyById(Long id);
    void saveEntity(CompanyDto companyDto);
}
