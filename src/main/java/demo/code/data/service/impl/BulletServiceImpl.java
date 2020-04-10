package demo.code.data.service.impl;

import demo.code.business.dto.BulletDto;
import demo.code.data.mapper.BulletMapper;
import demo.code.data.model.BulletType;
import demo.code.data.repository.BulletRepository;
import demo.code.data.service.BulletService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BulletServiceImpl implements BulletService {
    private final BulletRepository bulletRepository;

    public BulletServiceImpl(BulletRepository bulletRepository) {
        this.bulletRepository = bulletRepository;
    }

    public List<BulletDto> getTextBulletsByGroupIds(List<Long> groupIds) {
        return BulletMapper.toBulletDtos(bulletRepository.findByTypeAndGroupIdIn(BulletType.TEXT, groupIds));
    }

    public void saveTextBullet(BulletDto bulletDto) {
        bulletRepository.save(BulletMapper.toBulletModel(bulletDto, BulletType.TEXT));
    }
}
