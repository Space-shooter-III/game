package com.github.spaceshooteriii.game.entitys;

public enum EntityType {

    PLAYER(false, true);

    private final boolean CAN_DELETE;
    private final boolean CAN_MOVE;

    private EntityType(final boolean CAN_DELETE, final boolean CAN_MOVE) {

        this.CAN_DELETE = CAN_DELETE;
        this.CAN_MOVE = CAN_MOVE;

    }

    public boolean canDelete() {

        return this.CAN_DELETE;

    }

    public boolean canMove() {

        return this.CAN_MOVE;

    }

}
