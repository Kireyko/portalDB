package com.kireiko.portalDB;

public enum QueryType {
    SELECT("SELECT"), INSERT("INSERT"), UPDATE("UPDATE"), DELETE("DELETE"), CREATE("CREATE");

    private final String type;

    QueryType(String type) {
        this.type = type;
    }

    public static QueryType getByType(String type){
        QueryType[] values = values();
        for (QueryType queryType : values) {
            if (queryType.getType().equalsIgnoreCase(type)) {
                return queryType;
            }
        }
        throw new IllegalArgumentException("No type for provided: " + type);
    }

    public String getType() {
        return type;
    }


}
