

import fr.curiosow.cserv.core.deathmatch.DmGame;
import fr.curiosow.cserv.core.deathmatch.hmOG;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PersonalScoreboard
{

    private Player pl;
    private final UUID uuid;
    public ObjectiveSign objectiveSign;
    PersonalScoreboard(Player player)
    {
        this.pl = player;
        this.uuid = player.getUniqueId();

        this.objectiveSign = new ObjectiveSign("sidebar", "DevPlugin");

        reloadData();
        objectiveSign.addReceiver(player);
    }

    public void reloadData()
    {
    }

    public void setLines(String ip)
    {



            this.objectiveSign.setDisplayName("TITLE");
            this.objectiveSign.setLine(0, "§8                          §8");
            this.objectiveSign.setLine(1, "§7                          §8");
            this.objectiveSign.setLine(2, ip);


            this.objectiveSign.updateLines();

    }
    public void onLogout(){
        objectiveSign.removeReceiver(Bukkit.getServer().getOfflinePlayer(uuid));
    }

}
