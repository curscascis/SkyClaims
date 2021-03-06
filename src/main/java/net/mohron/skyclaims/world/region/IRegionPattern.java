package net.mohron.skyclaims.world.region;

import net.mohron.skyclaims.exception.InvalidRegionException;

import java.util.ArrayList;

public interface IRegionPattern {
	ArrayList<Region> generateRegionPattern();

	public Region nextRegion() throws InvalidRegionException;
}
