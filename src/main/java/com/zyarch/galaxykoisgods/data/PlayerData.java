package com.zyarch.galaxykoisgods.data;

import com.zyarch.galaxykoisgods.gods.God;
import com.zyarch.galaxykoisgods.gods.GalasGods;

import java.util.HashMap;

public class PlayerData
{
    private HashMap<String, Float> playerFavor = new HashMap<String, Float>();

    public PlayerData()
    {
        for(int i = 0; i < GalasGods.getGodListSize(); i++)
        {
            this.playerFavor.put(GalasGods.getGod(i).getName(), 0f);
        }
    }

    public void addFavor(String name, float value){
        float originalFavor = getFavor(name);

        this.playerFavor.replace(name, Math.max(-100f, Math.min((originalFavor + value), 100f)));
    }

    public float getFavor(String name)
    {
        return this.playerFavor.get(name);
    }

    public float getFavor(God god)
    {
        return this.playerFavor.get(god.getName());
    }

    public void clearFavor()
    {
        this.playerFavor.clear();
    }

    public void add(String string, float _float)
    {
        this.playerFavor.put(string, _float);
    }

}
