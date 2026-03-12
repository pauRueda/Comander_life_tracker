package com.example.comander_lifecounter.model;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private short lifeTotal;
    private short poison;
    private short cmDmgFrom1;
    private short cmDmgFrom2;
    private short cmDmgFrom3;
    private short cmDmgFrom4;


    public Player(String name, short lifeTotal) {
        this.name = name;
        this.lifeTotal = lifeTotal;
        this.poison = 0;
        this.cmDmgFrom1 = 0;
        this.cmDmgFrom2 = 0;
        this.cmDmgFrom3 = 0;
        this.cmDmgFrom4 = 0;
    }

    public void resetPlayer (short lifeTotal) {
        this.name = name;
        this.lifeTotal = lifeTotal;
        this.poison = 0;
        this.cmDmgFrom1 = 0;
        this.cmDmgFrom2 = 0;
        this.cmDmgFrom3 = 0;
        this.cmDmgFrom4 = 0;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getLifeTotal() {
        return lifeTotal;
    }

    public void setLifeTotal(short lifeTotal) {
        this.lifeTotal = lifeTotal;
    }

    public short getPoison() {
        return poison;
    }

    public void setPoison(short poison) {
        this.poison = poison;
    }

    public short getCmDmgFrom1() {
        return cmDmgFrom1;
    }

    public void setCmDmgFrom1(short cmDmgFrom1) {
        this.cmDmgFrom1 = cmDmgFrom1;
    }

    public short getCmDmgFrom2() {
        return cmDmgFrom2;
    }

    public void setCmDmgFrom2(short cmDmgFrom2) {
        this.cmDmgFrom2 = cmDmgFrom2;
    }

    public short getCmDmgFrom3() {
        return cmDmgFrom3;
    }

    public void setCmDmgFrom3(short cmDmgFrom3) {
        this.cmDmgFrom3 = cmDmgFrom3;
    }

    public short getCmDmgFrom4() {
        return cmDmgFrom4;
    }

    public void setCmDmgFrom4(short cmDmgFrom4) {
        this.cmDmgFrom4 = cmDmgFrom4;
    }
}
