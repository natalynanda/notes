package com.dh.notes.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dh.notes.model.Note;
import com.dh.notes.model.Tag;
import com.dh.notes.repository.NoteRepository;
import com.dh.notes.repository.TagRepository;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private TagRepository tagRepository;

    public Note createOrUpdate(Note note) {
        List<Tag> tagsToAdd = new ArrayList<>();
        for (Tag tag : note.getTags()) {
            Optional<Tag> existingTag = tagRepository.findByName(tag.getName());
            if (existingTag.isPresent()) {
                tagsToAdd.add(existingTag.get());
            } else {
                Tag newTag = new Tag();
                newTag.setName(tag.getName());
                tagRepository.save(newTag);
                tagsToAdd.add(newTag);
            }
        }
        note.setTags(tagsToAdd);

        if (note.getCreatedAt() == null) {
            note.setCreatedAt(LocalDateTime.now());
        }
        note.setUpdatedAt(LocalDateTime.now()); 
        return noteRepository.save(note);
    }

    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    public Optional<Note> findById(Long id) {
        return noteRepository.findById(id);
    }

    public void delete(Long id) {
        noteRepository.deleteById(id);
    }
}
