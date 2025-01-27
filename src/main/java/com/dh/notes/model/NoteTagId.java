package com.dh.notes.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class NoteTagId implements Serializable {
    @Column(name = "note_id")
    private Long noteId;
    @Column(name = "tag_id")
    private Long tagId;

    public NoteTagId() {}

    public NoteTagId(Long noteId, Long tagId) {
        this.noteId = noteId;
        this.tagId = tagId;
    }

    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteTagId that = (NoteTagId) o;
        return Objects.equals(noteId, that.noteId) && Objects.equals(tagId, that.tagId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noteId, tagId);
    }
}
