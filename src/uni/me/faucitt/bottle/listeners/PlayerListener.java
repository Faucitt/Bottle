package uni.me.faucitt.bottle.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.inventory.ItemStack;

import uni.me.faucitt.bottle.Bottle;
import uni.me.faucitt.bottle.config.BottleConfiguration;
import uni.me.faucitt.bottle.exceptions.BottleException;

public class PlayerListener implements Listener {

	public PlayerListener(Bottle plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	public Bottle getPlugin() {
		return plugin;
	}

	public void setPlugin(Bottle plugin) {
		this.plugin = plugin;
	}

	private Bottle plugin;

	@EventHandler
	public void OnPlayerLogin(PlayerLoginEvent event) throws BottleException {
		Player player = event.getPlayer();
		Server server = player.getServer();

		if (BottleConfiguration.kickNonOP) {
			if (!player.isOp()) {
				event.disallow(Result.KICK_OTHER,
						"Only ops can join this server! Contact the server administrator!");
				return;
			}
		}

		player.setHealth(20.0);
		player.sendMessage(ChatColor.AQUA + "[" + ChatColor.RED + "Bottle"
				+ ChatColor.AQUA + "] " + ChatColor.GOLD
				+ "Health restored to " + ChatColor.GREEN + "20"
				+ ChatColor.GOLD + "/" + ChatColor.RED + "20.");
	}

	@EventHandler
	public void OnPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		Server server = player.getServer();

		if (BottleConfiguration.flyOnJoin) {
			player.setAllowFlight(true);
		}

		if (BottleConfiguration.giveEnderChest) {
			if (!player.getInventory().contains(Material.ENDER_CHEST)) {
				player.getInventory().addItem(
						new ItemStack(Material.ENDER_CHEST, 1));
			}
		}

		if (BottleConfiguration.giveOpDiamond) {
			if (player.isOp()) {
				player.getInventory().addItem(
						new ItemStack(Material.DIAMOND, 1));
			}
		}

		if (BottleConfiguration.commandOnJoin != null
				&& BottleConfiguration.commandOnJoin != "") {
			server.dispatchCommand(player, BottleConfiguration.commandOnJoin);
		}
	}
}
