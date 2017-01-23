package cl.bennu.common.security.domain;

import cl.bennu.common.security.domain.base.BaseDomain;

public class Rol extends BaseDomain {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
