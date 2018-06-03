package com.kireiko.portalDB;

import java.util.List;

public class Request {
    private QueryType queryType;
    private List<String> columns;
    private String resource;
    private String owner;
    private List<String> rows;
    private String filter;

    public QueryType getQueryType() {
        return queryType;
    }

    public void setQueryType(QueryType queryType) {
        this.queryType = queryType;
    }

    public List<String>getColumns() {
        return columns;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public List<String> getRows() {
        return rows;
    }

    public void setRows(List<String> rows) {
        this.rows = rows;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    @Override
    public String toString() {
        return "Request{" +
                "queryType=" + queryType +
                ", columns=" + columns +
                ", resource='" + resource + '\'' +
                ", owner='" + owner + '\'' +
                ", rows=" + rows +
                ", filter='" + filter + '\'' +
                '}';
    }
}
