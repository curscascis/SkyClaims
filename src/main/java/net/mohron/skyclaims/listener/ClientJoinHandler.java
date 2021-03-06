package net.mohron.skyclaims.listener;

import net.mohron.skyclaims.SkyClaims;
import net.mohron.skyclaims.exception.CreateIslandException;
import net.mohron.skyclaims.permissions.Options;
import net.mohron.skyclaims.util.ConfigUtil;
import net.mohron.skyclaims.world.Island;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.event.network.ClientConnectionEvent;

public class ClientJoinHandler {
	@Listener
	public void onClientJoin(ClientConnectionEvent.Join event, @Root Player player) {
		if (!ConfigUtil.createIslandOnJoin()) return;

		try {
			new Island(player, Options.getStringOption(player.getUniqueId(), Options.DEFAULT_SCHEMATIC));
		} catch (CreateIslandException e) {
			// Oh well, we tried!
			SkyClaims.getInstance().getLogger().warn(String.format("Failed to create an island on join for %s.\n%s", player.getName(), e.getMessage()));
		}
	}
}
