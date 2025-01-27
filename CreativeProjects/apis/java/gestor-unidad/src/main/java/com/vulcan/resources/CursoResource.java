package com.vulcan.resources;

import com.vulcan.model.Curso;
import com.vulcan.repository.CursoRepository;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/cursos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CursoResource {

    private final CursoRepository cursoRepository;

    public CursoResource(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @GET
    public List<Curso> getAll() {
        return cursoRepository.listAll();
    }

    @POST
    @Transactional
    public void add(Curso curso) {
        cursoRepository.persist(curso);
    }
}