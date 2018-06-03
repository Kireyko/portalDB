package com.kireiko.portalDB;

import java.io.*;

public class ResponseWriter {
    public static void writeSelectResponse(BufferedOutputStream writer, BufferedInputStream fileContent) {
        try {
            writeContent(fileContent, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDDLResponse(BufferedOutputStream writer) {
        try {
            writer.write("<?xml version=\"1.1\" encoding=\"UTF-8\"?>".getBytes());
            writer.write("<information>".getBytes());
            writer.write("<message>Request was processed successfully</message>".getBytes());
            writer.write("</information>".getBytes());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDMLResponse(BufferedOutputStream writer, int rowsProcessed) {
        try {
            writer.write("<?xml version=\"1.1\" encoding=\"UTF-8\"?>".getBytes());
            writer.write("<information>".getBytes());
            writer.write("<message>Request was processed successfully</message>".getBytes());
            writer.write("<rowCount>".getBytes());
            writer.write(Integer.toString(rowsProcessed).getBytes());
            writer.write("</rowCount>".getBytes());
            writer.write("</information>".getBytes());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeNotFoundResponse(BufferedOutputStream writer) {
        try {
            writer.write("<?xml version=\"1.1\" encoding=\"UTF-8\"?>".getBytes());
            writer.write("<error>Resource is absent or name is incorrect </error>".getBytes());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeBadRequestResponse(BufferedOutputStream writer) {
        try {
            writer.write("<?xml version=\"1.1\" encoding=\"UTF-8\"?>".getBytes());
            writer.write("<error>Requested statement is not valid </error>".getBytes());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeContent(InputStream bufferedIn, OutputStream bufferedOut) throws IOException {
        byte[] buffer = new byte[8192];
        int count;
        while ((count = bufferedIn.read(buffer)) != -1) {
            bufferedOut.write(buffer, 0, count);
        }
    }
}
