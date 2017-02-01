package net.mohron.skyclaims.database;

import net.mohron.skyclaims.world.Island;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import java.util.*;


public interface IDatabase {


	void saveData(Collection<Island> islands);


	//These functions should be used only for migrations/swapping between data storage methods.
	//It's a database for a reason we have no reason to be managing all data in memory.
	HashMap<UUID, Island> loadData();
	void saveData(Map<UUID, Island> islands);


	void saveIsland(Island island);
	void removeIsland(Island island);
	//pass a UUID and field to load from DB
	ArrayList<Island> queryForIslands(String field, UUID uuid);
	//compares two dates and returns Island objects from them
	ArrayList<Island> queryForIslands(String field, Date date, char operator, Date date2);
	//allows deleting an Island from the DB by any UUID field
	boolean queryDeleteIsland(String field, UUID uuid);
	//allows deleting a player from the DB by any UUID field
	boolean queryDeletePlayer(String field, UUID uuid);
	//allows updating any String information in any update field, this includes numbers and UUID's
	boolean queryUpdateIsland(String field, UUID uuid,String updateField,String information);
	//allows updating any player information
	boolean queryUpdateIsland(String field, UUID uuid, String updateField);







}
