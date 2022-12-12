

// By Ilix360

import fr.curiosow.cserv.core.main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class OpenOtherGUI {

	public interface OpenNewGUI
	{
		public void executeFunction(Player p);
	}

	public static void OpenAnOtherGUI(Player p, OpenNewGUI classOfFunction)
	{
		p.getOpenInventory().close();

		Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), new Runnable()
		{

			@Override
			public void run()
			{
				classOfFunction.executeFunction(p);
			}
		}, 1);
	}

}
