package demo.code.business.mapper;

import demo.code.api.graphql.gro.Document;
import demo.code.business.dto.BulletDto;
import demo.code.business.dto.TextDto;

import java.util.List;
import java.util.stream.Collectors;

public class DocumentMapper {
    public static Document toDocumentGro(TextDto text, List<BulletDto> bulletDtos) {
        Document doc = new Document();
        doc.setId(Long.valueOf(String.join("/", text.getEntityId().toString(), text.getId().toString()).hashCode()));

        String bulletString = bulletDtos.stream().map(BulletDto::getBullet).collect(Collectors.joining("\n", "\n", "\n"));
        String content = text.getText().replaceAll("\\$\\{bullet\\}", bulletString);

        doc.setContent(content);
        return doc;
    }
}
