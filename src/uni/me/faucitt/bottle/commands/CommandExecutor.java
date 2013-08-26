package uni.me.faucitt.bottle.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import uni.me.faucitt.bottle.Bottle;

public class CommandExecutor implements org.bukkit.command.CommandExecutor {

	private Bottle plugin;

	public Bottle getPlugin() {
		return plugin;
	}

	public void setPlugin(Bottle plugin) {
		this.plugin = plugin;
	}

	public CommandExecutor(Bottle plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("bottle")) {
			sender.sendMessage("Bottle is a major plugin for Faucitt servers.");
			sender.sendMessage("~~~ List of Faucitt Commands ~~~");
			for (Command c : plugin.commands) {
				sender.sendMessage("/" + c.getName() + " - "
						+ c.getDescription());
			}
		}
		return false;
	}
}
