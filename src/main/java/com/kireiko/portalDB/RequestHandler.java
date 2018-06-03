package com.kireiko.portalDB;

import java.io.*;

class RequestHandler {
    private BufferedReader reader;
    private BufferedOutputStream writer;
    private ResourceReader resourceReader;
    private ResourceWriter resourceWriter;

    void setResourceReader(ResourceReader resourceReader) {
        this.resourceReader = resourceReader;
    }

    void setResourceWriter(ResourceWriter resourceWriter) {
        this.resourceWriter = resourceWriter;
    }

    RequestHandler(BufferedReader reader, BufferedOutputStream writer) {
        this.reader = reader;
        this.writer = writer;
    }

    void handle() {
        if (reader != null) {
            Request request;
            try {
                request = RequestParser.parseRequest(reader);
                System.out.println(request);

                if (request.getQueryType() == QueryType.SELECT) {
                    ResponseWriter.writeSelectResponse(
                            writer,
                            resourceReader.readContent(request.getResource()+".xml")
                    );
                } else if (request.getQueryType() == QueryType.CREATE) {
                    //creating file
                    //resourceWriter
                    ResponseWriter.writeDDLResponse(writer);
                } else if (request.getQueryType() == QueryType.INSERT) {
                    //file i
                    //resourceWriter
                    int rowsProcessed = 1;
                    ResponseWriter.writeDMLResponse(writer, rowsProcessed);
                }else if (request.getQueryType() == QueryType.UPDATE) {
                    //file u
                    //resourceWriter
                    int rowsProcessed = 2;
                    ResponseWriter.writeDMLResponse(writer, rowsProcessed);
                }else if (request.getQueryType() == QueryType.DELETE) {
                    //file d
                    //resourceWriter
                    int rowsProcessed = 3;
                    ResponseWriter.writeDMLResponse(writer, rowsProcessed);
                }

            } catch (FileNotFoundException e) {
                ResponseWriter.writeNotFoundResponse(writer);
                System.out.println("FileNotFoundException");
            } catch (IOException e) {
                ResponseWriter.writeBadRequestResponse(writer);
                System.out.println("IOException");
            }
        }


    }

}
