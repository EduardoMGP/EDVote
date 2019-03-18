/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edvote;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author EduardoMGP
 */
public class EDVote extends JavaPlugin {
  
    private static EDVote plugin;
    
    @Override
    public void onEnable() {
        plugin = this;
        this.saveDefaultConfig();
        if (getServer().getPluginManager().getPlugin("Votifier") != null) {
            getServer().getPluginManager()
                    .registerEvents(new OnVote(), this);

            Bukkit.getConsoleSender().sendMessage("&b--- EDVote ---");
            Bukkit.getConsoleSender().sendMessage("&fPlugin Habilitado com sucesso");
            Bukkit.getConsoleSender().sendMessage("&fDesenvolvido por &bEduardoMGP");
            Bukkit.getConsoleSender().sendMessage("&fVersao: &b1.0");
            Bukkit.getConsoleSender().sendMessage("&b--- EDVote ---");

        } else {

            Bukkit.getConsoleSender().sendMessage("&b--- EDVote ---");
            Bukkit.getConsoleSender().sendMessage("&fPlugin nao pode ser habilitado corretamente");
            Bukkit.getConsoleSender().sendMessage("&fÉ necessario baixar o plugin &bVotifier");
            Bukkit.getConsoleSender().sendMessage("&fPara que este funcione");
            Bukkit.getConsoleSender().sendMessage("&b--- EDVote ---");
            getPluginLoader().disablePlugin(this);

        }

    }

    @Override
    public void onDisable() {
        this.saveDefaultConfig();
        Bukkit.getConsoleSender().sendMessage("&b--- EDVote ---");
        Bukkit.getConsoleSender().sendMessage("&fPlugin desabilitado com sucesso");
        Bukkit.getConsoleSender().sendMessage("&fDesenvolvido por &bEduardoMGP");
        Bukkit.getConsoleSender().sendMessage("&fVersao: &b1.0");
        Bukkit.getConsoleSender().sendMessage("&b--- EDVote ---");
    }

    public static EDVote getPluginEDVote(){
        return plugin;
    } 
}
