package com.askly.monu.askly.Services;

import com.askly.monu.askly.Repositories.TagRepo;
import com.askly.monu.askly.models.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    private TagRepo tagRepo;
    public TagService(TagRepo tagRepo) {
        this.tagRepo = tagRepo;
    }

    public List<Tag> getAllTags(){
        return tagRepo.findAll();
    }
}
