package net.mohron.skyclaims.world.region;

import net.mohron.skyclaims.SkyClaims;
import net.mohron.skyclaims.exception.InvalidRegionException;
import net.mohron.skyclaims.util.ClaimUtil;
import net.mohron.skyclaims.util.ConfigUtil;
import net.mohron.skyclaims.world.Coordinate;
import org.spongepowered.api.text.Text;

import java.util.ArrayList;

public class PositiveQuadrantPattern implements IRegionPattern {
	private static final SkyClaims PLUGIN = SkyClaims.getInstance();
	private static final int SPAWN_REGIONS = ConfigUtil.getSpawnRegions();

	/**
	 * A method to generate a region-scaled spiral region and return the x/y pairs of each region
	 *
	 * @return An ArrayList of Points containing the x,y of regions, representing a spiral shape
	 */
	public ArrayList<Region> generateRegionPattern() {

	}

	public Region nextRegion() throws InvalidRegionException {



	}

	@Override
	public Coordinate lastLocation() {
		return null;
	}
}