package net.mohron.skyclaims.world.region;


import net.mohron.skyclaims.SkyClaims;
import net.mohron.skyclaims.config.ConfigManager;
import net.mohron.skyclaims.util.ConfigUtil;

/**
 * Created by adam_ on 01/17/17.
 */
public class Patterns {

    public static IRegionPattern get(){

        if(ConfigUtil.getPattern().toLowerCase() == "spiral") {
            return new SpiralRegionPattern();
        }
        return new SpiralRegionPattern();
    }
}
