package ar.com.BackEndSpringboot.api.services;

import ar.com.BackEndSpringboot.api.models.Project;
import ar.com.BackEndSpringboot.api.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService{
    @Autowired
    ProjectRepository projectRepository;

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public Optional <Project> getOne(Long id){
        return projectRepository.findById(id);
    }

    public void saveProjects(Project project) {
        projectRepository.save(project);
    }

    public void deleteProjects(Long id) {
        projectRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return projectRepository.existsById(id);
    }
}
