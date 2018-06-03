package com.kireiko.portalDB;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class RequestParser {

    static Request parseRequest(BufferedReader reader) throws IOException {

        StringBuffer sourceRequest = new StringBuffer();
        String value= reader.readLine();
        if ((value!=null)&&(!value.isEmpty())){
            sourceRequest.append(value);
        }
        return parseJson(sourceRequest.toString());
    }

    private static Request parseJson(String jsonData) {
        System.out.println("parsing source file.. ");
        System.out.println(jsonData);
        Request request = new Request();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(jsonData);
            String value;
            value = rootNode.path("queryType").asText();
            request.setQueryType(QueryType.getByType(value));
            value = rootNode.path("resource").asText();
            request.setResource(value);
            value = rootNode.path("owner").asText();
            request.setOwner(value);
            value = rootNode.path("filter").asText();
            request.setFilter(value);

            Iterator<JsonNode> nodeElements =rootNode.path("columns").elements();
            List<String> elements = new ArrayList<>();
            while(nodeElements.hasNext()){
                JsonNode element = nodeElements.next();
                elements.add(element.asText());
            }
            request.setColumns(elements);

            nodeElements=rootNode.path("rows").elements();
            elements.clear();
            while(nodeElements.hasNext()){
                JsonNode element = nodeElements.next();
                elements.add(element.asText());
            }
            request.setRows(elements);

        } catch (IOException e) {
            e.printStackTrace();
        }


        return request;
    }


}