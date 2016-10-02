package io.objectbox.performanceapp;

/**
 * Created by Markus on 01.10.2016.
 */
public class TestType {
    public static final String CRUD = "Basic operations (CRUD)";
    public static final String UPDATE_SCALARS = "Update Scalars";
    public static final String CRUD_INDEXED = "Bulk operations (CRUD) - indexed";
    public static final String LOOK_UP_STRING = "Look up string using index";

    public static TestType[] ALL = {
            new TestType(CRUD, "crud"),
            new TestType(UPDATE_SCALARS, "update-scalars"),
            new TestType(CRUD_INDEXED, "crud-indexed"),
            new TestType(LOOK_UP_STRING, "lookup-string"),
    };

    public final String name;
    public final String nameShort;

    public TestType(String name, String nameShort) {
        this.name = name;
        this.nameShort = nameShort;
    }

    @Override
    public String toString() {
        return name;
    }
}
