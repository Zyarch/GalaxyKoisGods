package com.Zyarch.GalaxyKoisGods.data;

import com.Zyarch.GalaxyKoisGods.gods.GGod;
import com.Zyarch.GalaxyKoisGods.gods.God;
import java.util.HashMap;

public class PlayerData
{
    private HashMap<String, Integer> playerFavor = new HashMap<String, Integer>();

    public PlayerData()
    {
        for(int i = 0; i < God.getGodListSize(); i++)
        {
            this.playerFavor.put(God.getGod(i).getName(), 0);
        }
    }

    public void addFavor(String name, int value){
        int originalFavor = getFavor(name);

        this.playerFavor.replace(name, Math.max(-100, Math.min(originalFavor + value, 100)));
    }

    public int getFavor(String name)
    {
        return this.playerFavor.get(name);
    }

    public int getFavor(GGod god)
    {
        return this.playerFavor.get(god.getName());
    }

    public void clearFavor()
    {
        this.playerFavor.clear();
    }

    public void add(String string, Integer integer)
    {
        this.playerFavor.put(string, integer);
    }
}
