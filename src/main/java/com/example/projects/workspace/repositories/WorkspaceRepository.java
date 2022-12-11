package com.example.projects.workspace.repositories;

import com.example.projects.workspace.entities.Workspace;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface WorkspaceRepository extends PagingAndSortingRepository<Workspace, Long> {
}