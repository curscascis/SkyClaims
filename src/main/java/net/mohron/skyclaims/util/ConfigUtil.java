package net.mohron.skyclaims.util;

import net.mohron.skyclaims.SkyClaims;
import net.mohron.skyclaims.config.type.GlobalConfig;
import net.mohron.skyclaims.config.type.MysqlConfig;
import net.mohron.skyclaims.config.type.SqliteConfig;
import net.mohron.skyclaims.database.IDatabase;
import net.mohron.skyclaims.database.MysqlDatabase;
import net.mohron.skyclaims.database.SqliteDatabase;
import org.spongepowered.api.Game;
import org.spongepowered.api.Server;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.WorldArchetypes;
import org.spongepowered.api.world.gen.WorldGeneratorModifier;
import org.spongepowered.api.world.gen.WorldGeneratorModifiers;
import org.spongepowered.api.world.storage.WorldProperties;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ConfigUtil {
	private static final SkyClaims PLUGIN = SkyClaims.getInstance();
	private static final Game GAME = PLUGIN.getGame();
	private static GlobalConfig config = PLUGIN.getConfig();

	@SuppressWarnings("OptionalGetWithoutIsPresent")
	public static World getWorld() {
		Server server = GAME.getServer();
		Optional<World> world = (config.world != null) ? server.getWorld(config.world.worldName) : Optional.empty();
		return world.isPresent() ? world.get() : WorldUtil.getDefaultWorld();
	}

	public static int getIslandHeight() {
		return (config.world == null || config.world.defaultHeight == null) ?
				72 : config.world.defaultHeight;
	}

	public static Optional<List<String>> getCreateCommands() {
		if (config.misc == null || config.misc.createCommands == null || config.misc.createCommands.isEmpty())
			return Optional.empty();
		return Optional.of(config.misc.createCommands);
	}

	public static Optional<List<String>> getResetCommands() {
		if (config.misc == null || config.misc.resetCommands == null || config.misc.resetCommands.isEmpty())
			return Optional.empty();
		return Optional.of(config.misc.resetCommands);
	}

	public static SqliteConfig getSqliteDatabaseConfig() {
		return (config == null ||
				config.storage == null ||
				config.storage.sqlite == null) ? new SqliteConfig() : config.storage.sqlite;
	}

	public static MysqlConfig getMysqlDatabaseConfig() {
		return (config == null ||
				config.storage == null ||
				config.storage.mysql == null) ? new MysqlConfig() : config.storage.mysql;
	}

	public static int getSpawnRegions() {
		return (config.world == null ||
				config.world.spawnRegions == null ||
				config.world.spawnRegions < 1) ?
				1 : (int) Math.pow(config.world.spawnRegions, 2);
	}

	public static IDatabase getDatabase() {
		if (config.storage != null && config.storage.type != null) {
			if (config.storage.type.equalsIgnoreCase("sqlite"))
				return (PLUGIN.getDatabase() != null) ? PLUGIN.getDatabase() : new SqliteDatabase();
			else if (config.storage.type.equalsIgnoreCase("mysql"))
				return (PLUGIN.getDatabase() != null) ? PLUGIN.getDatabase() : new MysqlDatabase();
			else
				throw new UnsupportedOperationException("Database type not supported, should not continue.");
		}

		return new SqliteDatabase();
	}

	public static Integer getDatabasePort() {
		return (config.storage == null ||
				config.storage.mysql == null ||
				config.storage.mysql.port == null) ?
				3306 : config.storage.mysql.port;
	}

	public static boolean createIslandOnJoin() {
		return (config.misc == null || config.misc.islandOnJoin == null) ? false : config.misc.islandOnJoin;
	}

	public static void setVoidGenerator() {
		Optional<WorldProperties> worldProperties = GAME.getServer().getDefaultWorld();
		if (!worldProperties.isPresent()) {
			try {
				GAME.getServer().createWorldProperties("", WorldArchetypes.THE_VOID);
			} catch (IOException e) {
				PLUGIN.getLogger().error("Failed to create worldName: " + e);
			}
		} else {
			Collection<WorldGeneratorModifier> generatorModifiers = null;
			generatorModifiers.add(WorldGeneratorModifiers.VOID);
			worldProperties.get().setGeneratorModifiers(generatorModifiers);
		}
	}
}