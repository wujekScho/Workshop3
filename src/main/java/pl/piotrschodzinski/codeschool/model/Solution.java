package pl.piotrschodzinski.codeschool.model;

import java.time.LocalDateTime;

public class Solution {
    private int id;
    private LocalDateTime created;
    private LocalDateTime updated;
    private String description;
    private int exerciseId;
    private int userId;

    public Solution() {
    }

    public Solution(String description, int exerciseId, int userId) {
        this.created = LocalDateTime.now();
        this.description = description;
        this.exerciseId = exerciseId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
