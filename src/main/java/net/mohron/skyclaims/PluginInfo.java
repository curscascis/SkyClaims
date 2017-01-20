package net.mohron.skyclaims;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

public class PluginInfo {
	public static final String ID = "skyclaims";
	public static final String NAME = "SkyClaims";
	public static final String VERSION = "1.0.0-beta10";
	public static final String DESCRIPTION = "SkyClaims is an Island Management plugin that integrates with GriefPrevention.";
	public static final String AUTHORS = "Mohron, Cossacksman";
	public static final double GP_API_VERSION = 0.1;
	public static final Text DISABLE_MESSAGE = Text.of("It seems SkyClaims is Having a huge Issue Internally. " +
														"We have disabled your plugin to make sure your data or claims " +
														"Will not be damaged or corrupted")
														.toBuilder().color(TextColors.RED).build();

}