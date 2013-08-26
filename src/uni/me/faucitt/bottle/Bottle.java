package uni.me.faucitt.bottle;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import uni.me.faucitt.bottle.exceptions.BottleException;

public class Bottle extends JavaPlugin {
	
	public static List<BottleException> bottleExceptions = new ArrayList<BottleException>();
	
	public void onEnable() {
	}
	
	public void onDisable() {
	}
	
	public void Log(String message) {
		getLogger().info(message);
	}
}
