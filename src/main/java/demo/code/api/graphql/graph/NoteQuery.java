package demo.code.api.graphql.graph;

import demo.code.api.graphql.gro.Note;
import demo.code.business.controller.NoteController;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NoteQuery {

    private NoteController noteController;

    public NoteQuery(NoteController noteController) {
        this.noteController = noteController;
    }

    @GraphQLQuery(name = "notes")
    public List<Note> getNotes() {
        return noteController.getNotes();
    }
}
