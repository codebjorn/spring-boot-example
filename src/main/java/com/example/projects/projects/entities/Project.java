package com.example.projects.projects.entities;

import com.example.projects.workspace.entities.Workspace;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String slug;

    @Column
    private String description;

    @ManyToMany(mappedBy = "projects")
    private List<Workspace> workspaces;
}
