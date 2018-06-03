package com.kireiko.portalDB;

import java.io.*;

class ResourceReader {
    private String dbFolderPath;

    String getDbFolderPath() {
        return dbFolderPath;
    }

    void setDbFolderPath(String dbFolderPath) {
        this.dbFolderPath = dbFolderPath;
    }

    BufferedInputStream readContent(String resource) throws IOException {
        File file = new File(getDbFolderPath(),resource);//
        if (!file.exists()) {
            throw new FileNotFoundException("file (" + file.toString() + ") not found ");
        }
        return  new BufferedInputStream(new FileInputStream(file));
    }

}
