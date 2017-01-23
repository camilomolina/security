package cl.bennu.common.security.enums;

public enum DBEnum {

    MONGO_LABS(1L, "mondodb-labs")
    , SECURITY(2L, "security");

    private Long id;
    private String name;


    DBEnum(Long id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

}
