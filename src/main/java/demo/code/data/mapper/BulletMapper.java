package demo.code.data.mapper;

import demo.code.business.dto.BulletDto;
import demo.code.data.model.BulletModel;
import demo.code.data.model.BulletType;

import java.util.List;
import java.util.stream.Collectors;

public class BulletMapper {
    public static BulletDto toBulletDto(BulletModel model) {
        return new BulletDto().setId(model.getId())
                .setGroupId(model.getGroupId())
                .setBullet(model.getBullet());
    }

    public static List<BulletDto> toBulletDtos(List<BulletModel> models) {
        return models.stream().collect(
                Collectors.mapping(o -> toBulletDto(o), Collectors.toList())
        );
    }

    public static BulletModel toBulletModel(BulletDto bulletDto, BulletType type) {
        return new BulletModel().setBullet(bulletDto.getBullet())
                .setGroupId(bulletDto.getGroupId())
                .setType(type);
    }
}
