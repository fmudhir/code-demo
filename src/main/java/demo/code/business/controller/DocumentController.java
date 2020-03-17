package demo.code.business.controller;

import demo.code.api.graphql.gro.Document;
import demo.code.business.dto.BulletDto;
import demo.code.business.dto.CompanyDto;
import demo.code.business.dto.TextDto;
import demo.code.business.mapper.DocumentMapper;
import demo.code.data.service.BulletService;
import demo.code.data.service.EntityService;
import demo.code.data.service.TextService;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class DocumentController {
    private TextService textService;
    private BulletService bulletService;
    private EntityService entityService;

    public DocumentController(TextService textService, BulletService bulletService, EntityService entityService) {
        this.textService = textService;
        this.bulletService = bulletService;
        this.entityService = entityService;
    }

    public List<Document> getDocuments(String topic) {

        Optional<CompanyDto> company = entityService.getCompanyByName(topic);
        if (!company.isPresent())
            return Collections.emptyList();

        // 1 topic can have more than 1 document
        List<TextDto> texts = textService.getTextsByEntityId(company.get().getId());

        List<Long> groupIds = texts.stream().map(TextDto::getId).collect(Collectors.toList());
        List<BulletDto> bullets = bulletService.getTextBulletsByGroupIds(groupIds);

        List<Document> documents = new ArrayList<>();
        for (TextDto text : texts) {
            // filter bullets that are tied to text
            List<BulletDto> textBullets = bullets.stream().filter(o -> text.getId().equals(o.getGroupId())).collect(Collectors.toList());
            documents.add(DocumentMapper.toDocumentGro(text, textBullets));
        }

        return documents;
    }
}
