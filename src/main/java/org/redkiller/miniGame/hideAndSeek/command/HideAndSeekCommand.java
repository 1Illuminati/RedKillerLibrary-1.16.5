package org.redkiller.miniGame.hideAndSeek.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.redkiller.command.AbstractPlayerCommand;
import org.redkiller.entity.livingentity.player.NewPlayer;

import java.util.List;

public class HideAndSeekCommand extends AbstractPlayerCommand {
    @Override
    public String getName() {
        return "hideAndSeek";
    }

    @Override
    public boolean onCommand(CommandSender sender, String label, String[] args) {
        NewPlayer player = NewPlayer.getNewPlayer((Player) sender);

        if (args.length == 0) {
            return true;
        }

        switch (args[0]) {
            case "start":
            case "stop":
            case "join":
            case "leave":
            case "spawn":
            case "setSpawn":
            case "weapon":
            case "list":
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String label, String[] args) {
        return null;
    }
}
