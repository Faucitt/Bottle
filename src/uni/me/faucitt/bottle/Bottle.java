package uni.me.faucitt.bottle;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.plugin.java.JavaPlugin;

import uni.me.faucitt.bottle.commands.CommandExecutor;
import uni.me.faucitt.bottle.exceptions.BottleException;
import uni.me.faucitt.bottle.listeners.PlayerListener;

public class Bottle extends JavaPlugin {

	public static List<BottleException> bottleExceptions = new ArrayList<BottleException>();
	public List<Command> commands = new ArrayList<Command>();
	public PlayerListener playerListener;

	@SuppressWarnings("null")
	public void onEnable() {
		Command commandBottle = null;
		commandBottle.setLabel("bottle");
		commandBottle.setDescription("Gives a list of all Bottle commands");

		commands.add(commandBottle);

		getCommand("bottle").setExecutor(new CommandExecutor(this));

		playerListener = new PlayerListener(this);
	}

	public void onDisable() {
	}

	public void Log(String message) {
		getLogger().info(message);
	}
}
