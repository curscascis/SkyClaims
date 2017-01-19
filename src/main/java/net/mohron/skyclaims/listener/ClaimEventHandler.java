package net.mohron.skyclaims.listener;

import me.ryanhamshire.griefprevention.api.claim.Claim;
import me.ryanhamshire.griefprevention.api.event.CreateClaimEvent;
import me.ryanhamshire.griefprevention.api.event.DeleteClaimEvent;
import me.ryanhamshire.griefprevention.api.event.ResizeClaimEvent;
import net.mohron.skyclaims.SkyClaims;
import net.mohron.skyclaims.util.ConfigUtil;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;


public class ClaimEventHandler {
	private static final SkyClaims PLUGIN = SkyClaims.getInstance();
	@Listener
	public void onClaimCreate(CreateClaimEvent event, @Root Player player) {
		Claim claim = event.getClaim();
		if (claim.getWorld() != ConfigUtil.getWorld() || !claim.isBasicClaim()) return;

		player.sendMessage(Text.of(TextColors.RED, "You cannot create claims in this dimension!"));
		event.setCancelled(true);
	}

	@Listener
	public void onClaimDelete(DeleteClaimEvent event, @Root Player player) {
		Claim claim = event.getClaim();
<<<<<<< HEAD
		if (event.isCancelled() || !SkyClaims.islandClaims.contains(claim)) return;
		PLUGIN.getLogger().info("Someone is trying to delete a claim...");
=======
		if (!SkyClaims.islandClaims.contains(claim)) return;

>>>>>>> bb50c56c1152f73c8c99e0d6ebe1ccdff6203834
		player.sendMessage(Text.of(TextColors.RED, "You cannot delete an island claim!"));
		event.setCancelled(true);
	}

	@Listener
	public void onClaimResize(ResizeClaimEvent event, @Root Player player) {
		Claim claim = event.getClaim();
		if (!SkyClaims.islandClaims.contains(claim)) return;

		player.sendMessage(Text.of(TextColors.RED, "You cannot resize an island claim!"));
		event.setCancelled(true);
	}
}
