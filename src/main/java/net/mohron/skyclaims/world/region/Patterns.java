package net.mohron.skyclaims.world.region;

import net.mohron.skyclaims.SkyClaims;
import net.mohron.skyclaims.config.type.GlobalConfig;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class Patterns {
	private static final SkyClaims PLUGIN = SkyClaims.getInstance();
	private static GlobalConfig config = PLUGIN.getConfig();

	public static IRegionPattern get() {

		if (config.misc.algorithmType.equalsIgnoreCase("spiral")) {
			return new SpiralRegionPattern();
		}
		return new SpiralRegionPattern();
	}

	private static void saveAlgData(HashMap<String, String> algData) throws IOException {
		Path algorithmData = Paths.get(PLUGIN.configDir.toString(), "", "algorithmData.dat");
		FileOutputStream fileOutputStream = new FileOutputStream(algorithmData.toFile());
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

		objectOutputStream.writeObject(algData);
		objectOutputStream.close();
	}

	private static HashMap<String, String> loadAlgData() throws IOException, ClassNotFoundException {
		Path algorithmData = Paths.get(PLUGIN.configDir.toString(), "", "algorithmData.dat");
		FileInputStream fileInputStream = new FileInputStream(algorithmData.toFile());
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

		HashMap<String, String> algData = (HashMap<String, String>) objectInputStream.readObject();
		objectInputStream.close();
		return algData;
	}
}
