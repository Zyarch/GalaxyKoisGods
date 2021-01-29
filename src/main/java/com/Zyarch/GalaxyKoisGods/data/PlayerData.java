package com.Zyarch.GalaxyKoisGods.data;

import com.Zyarch.GalaxyKoisGods.gods.GGod;
import com.Zyarch.GalaxyKoisGods.gods.God;
import java.util.HashMap;

public class PlayerData
{
    private HashMap<String, Float> playerFavor = new HashMap<String, Float>();

    public PlayerData()
    {
        for(int i = 0; i < God.getGodListSize(); i++)
        {
            this.playerFavor.put(God.getGod(i).getName(), 0f);
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

    public float getFavor(GGod god)
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
