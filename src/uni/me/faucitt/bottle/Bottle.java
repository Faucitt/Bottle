package uni.me.faucitt.bottle;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.plugin.java.JavaPlugin;

import uni.me.faucitt.bottle.commands.CommandExecutor;
import uni.me.faucitt.bottle.exceptions.BottleException;

public class Bottle extends JavaPlugin {
	
	public static List<BottleException> bottleExceptions = new ArrayList<BottleException>();
	public static List<Command> commands = new ArrayList<Command>();
	
	public void onEnable() {
		Command commandBottle = null;
		commandBottle.setLabel("bottle");
		commandBottle.setDescription("Gives a list of all Bottle commands");
		
		commands.add(commandBottle);
		
		getCommand("bottle").setExecutor(new CommandExecutor(this));
	}
	
	public void onDisable() {
	}
	
	public void Log(String message) {
		getLogger().info(message);
	}
}
