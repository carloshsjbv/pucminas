package br.com.pucminas.user.entity;

public enum EnumStatus {

    INACTIVE(0),
    ACTIVE(1);

    private final int status;

    EnumStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
