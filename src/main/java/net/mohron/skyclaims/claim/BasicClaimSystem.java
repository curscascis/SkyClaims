package net.mohron.skyclaims.claim;

import com.flowpowered.math.vector.Vector3i;
import com.google.common.collect.Maps;
import me.ryanhamshire.griefprevention.api.claim.Claim;
import me.ryanhamshire.griefprevention.api.claim.ClaimResult;
import me.ryanhamshire.griefprevention.api.claim.ClaimType;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.world.World;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class BasicClaimSystem implements IClaimSystem {
	private Map<UUID, Optional<Claim>> claims = Maps.newHashMap();

	public BasicClaimSystem() {

	}

	public ClaimResult createClaim(World world, Vector3i a, Vector3i b, UUID claimId, Claim parent, ClaimType claimType, boolean cuboid, Player player) {
		// TODO:- Create Claim
		// TODO:- Add claim to claims
		// TODO:- Return Claim Result
		return null;
	}

	public Optional<Claim> getClaim(UUID claimId) {
		return claims.get(claimId);
	}
}
