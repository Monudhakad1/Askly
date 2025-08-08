package com.askly.monu.askly.Services;

import com.askly.monu.askly.DTO.TagDto;
import com.askly.monu.askly.Repositories.TagRepo;
import com.askly.monu.askly.models.Tag;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    private TagRepo tagRepo;
    public TagService(TagRepo tagRepo) {
        this.tagRepo = tagRepo;
    }

    public List<Tag> getAllTags(){
        return tagRepo.findAll();
    }

    public Optional<Tag> getTagById(Long id) {
        return tagRepo.findById(id);
    }
    public Tag createTag(TagDto tagDTO) {
        Tag tag = new Tag();
        tag.setName(tagDTO.getName());
        return tagRepo.save(tag);
    }

    public void deleteTag(Long id) {
        tagRepo.deleteById(id);
    }
}
