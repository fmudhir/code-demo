package demo.code.data.service;

import demo.code.business.dto.BulletDto;

import java.util.List;

public interface BulletService {
    List<BulletDto> getTextBulletsByGroupIds(List<Long> groupIds);
    void saveTextBullet(BulletDto bulletDto);
}
