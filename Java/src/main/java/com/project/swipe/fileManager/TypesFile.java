package com.project.swipe.fileManager;

public enum TypesFile {
    IMAGE("img"),
    FILE("file");

    private String nameFolder;

    TypesFile(String nameFolder) {
        this.nameFolder = nameFolder;
    }

    public String getNameFolder() {
        return nameFolder;
    }

}
