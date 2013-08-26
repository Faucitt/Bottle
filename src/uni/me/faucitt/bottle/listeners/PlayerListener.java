package uni.me.faucitt.bottle.listeners;

import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import uni.me.faucitt.bottle.Bottle;
import uni.me.faucitt.bottle.config.BottleConfiguration;
import uni.me.faucitt.bottle.exceptions.BottleException;

public class PlayerListener implements Listener {
	
	public PlayerListener(Bottle plugin) {
		this.plugin = plugin;
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
    	
    	if (BottleConfiguration.flyOnLogin) {
    		player.setAllowFlight(true);
    	}
    	
    	if (BottleConfiguration.kickNonOP) {
    		if (!player.isOp()) {
    			event.disallow(Result.KICK_OTHER, "Only ops can join this server! Contact the server administrator!");
    			return;
    		}
    	}
    	
    	if (BottleConfiguration.commandOnLogin != null && BottleConfiguration.commandOnLogin != "") {
    		server.dispatchCommand(player, BottleConfiguration.commandOnLogin);
    	}
    }
}
