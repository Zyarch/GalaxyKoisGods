package com.Zyarch.GalaxyKoisGods.gods;

public enum GodEnum {
    Amara(0),
    KelDerash(1),
    Lithaga(2),
    Ygthravil(3),
    Lovahn(4),
    Eldus(5),
    Tyrin(6),
    Xyrthas(7),
    Reptak(8),
    Jaspren(9);
    private final int value;

    private GodEnum(int value){ this.value = value;}

    public int getValue() { return value; }

}
