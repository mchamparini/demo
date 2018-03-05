package com.example.demo;

import org.springframework.stereotype.Component;

/**
 * Created by martin on 1/7/2017.
 */
@Component
public class ControlFiles {
    private String project_name;
    private String table_raw_name;
    private String files_origin;
    private String files_processed;

    public ControlFiles(String project_name, String table_raw_name, String files_origin, String files_processed) {
        this.project_name = project_name;
        this.table_raw_name = table_raw_name;
        this.files_origin = files_origin;
        this.files_processed = files_processed;
    }

    public ControlFiles() {
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getTable_raw_name() {
        return table_raw_name;
    }

    public void setTable_raw_name(String table_raw_name) {
        this.table_raw_name = table_raw_name;
    }

    public String getFiles_origin() {
        return files_origin;
    }

    public void setFiles_origin(String files_origin) {
        this.files_origin = files_origin;
    }

    public String getFiles_processed() {
        return files_processed;
    }

    public void setFiles_processed(String files_processed) {
        this.files_processed = files_processed;
    }

    @Override
    public String toString() {
        return "ControlFiles{" +
                "project_name='" + project_name + '\'' +
                ", table_raw_name='" + table_raw_name + '\'' +
                ", files_origin='" + files_origin + '\'' +
                ", files_processed='" + files_processed + '\'' +
                '}';
    }
}
