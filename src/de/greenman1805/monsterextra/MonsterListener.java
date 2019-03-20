package de.greenman1805.monsterextra;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class MonsterListener implements Listener {

	@EventHandler
	public void MonsterKill(EntityDeathEvent e) {
		Entity entity = e.getEntity();
		if (e.getEntity().getKiller() instanceof Player) {
			Player p = e.getEntity().getKiller();
			if (Main.shards != 0) {
				if (p.hasPermission("monsterextra.reward")) {
					if (entity instanceof Monster) {
						Main.econ.depositPlayer(p, Main.shards);
						p.sendMessage("§c + §a" + Main.shards + " Shards");
						//p.sendMessage(Main.prefix + "Du hast §9" + Main.shards + " Shards §7für das Töten eines Monsters erhalten.");
					}
				}
			}
		}
	}

}
