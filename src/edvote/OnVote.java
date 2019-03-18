/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edvote;

import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 *
 * @author EduardoMGP
 */
public class OnVote implements Listener {
    
    private EDVote plugin;
    
    public OnVote(){
        plugin = EDVote.getPluginEDVote();
    }
    
    @EventHandler
    public void onVotifierEvent(VotifierEvent event) {
        String player = event.getVote().getUsername();
        Player p = Bukkit.getPlayer(player);
        if(p != null){
            for(String cmd : plugin.getConfig().getStringList("comandos")){
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), cmd.replaceAll("%player%", player));
            }
            for(String msg : plugin.getConfig().getStringList("broadcast_vote")){
                Bukkit.broadcastMessage(msg.replaceAll("%player%", player)
                                                         .replaceAll("&", "§")
                );
            }

        } else {
            Bukkit.broadcastMessage(plugin.getConfig().getString("broadcast_votou_offline")
                    .replaceAll("%player%", player)
                    .replaceAll("&", "§")
            );

            
        }
        
    }
}
