package demo.code.data.mapper;

import demo.code.business.dto.CompanyDto;
import demo.code.data.model.EntityModel;
import demo.code.data.model.EntityType;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EntityMapper {
    public static EntityModel toEntityModel(CompanyDto companyDto) {
        return new EntityModel().setType(EntityType.COMPANY).setName(companyDto.getName());
    }

    public static Optional<CompanyDto> toCompanyDto(Optional<EntityModel> model) {
        if (!model.isPresent())
            return Optional.empty();
        return Optional.of(new CompanyDto().setId(model.get().getId()).setName(model.get().getName()));
    }

    public static CompanyDto toCompanyDto(EntityModel model) {
        return new CompanyDto().setId(model.getId()).setName(model.getName());
    }

    public static List<CompanyDto> toCompanyDtos(List<EntityModel> models) {
        return models.stream().collect(
                Collectors.mapping(o -> toCompanyDto(o), Collectors.toList())
        );
    }
}
