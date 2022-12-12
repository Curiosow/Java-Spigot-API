

// By Ilix360

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class FillBlackGlassGUI
{
	public static void FillAll(Inventory inv)
	{
		for(int i = 0; i != inv.getSize(); i++)
		{
			if(inv.getItem(i) == null)
				inv.setItem(i, getBLackGlass());
		}
	}

	public static void FillElse(Inventory inv, List<Integer> slotKeepEmpty)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i : slotKeepEmpty)
		    list.add(i);

		for(int i = 0; i != inv.getSize(); i++)
		{
			if(inv.getItem(i) == null && !list.contains(i))
				inv.setItem(i, getBLackGlass());
		}
	}

	public static void FillJust(Inventory inv, ArrayList<Integer> arrayList)
	{
		for(int i : arrayList)
			inv.setItem(i, getBLackGlass());
	}

	public static void FillBetween(Inventory inv, int min, int max)
	{
		for(int i = min; i != max + 1; i++)
			inv.setItem(i, getBLackGlass());
	}

	public static ItemStack getBLackGlass()
	{
		ItemStack ivoid = new ItemStack(Material.STAINED_GLASS_PANE);
		ItemMeta vMeta = ivoid.getItemMeta();
		vMeta.setDisplayName("§8");
		ivoid.setDurability((short) (15));
		ivoid.setItemMeta(vMeta);
		return ivoid;
	}

}
