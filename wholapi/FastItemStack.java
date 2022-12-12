

// By Ilix360 (edited by Curiosow)

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Map;

public class FastItemStack
{
	public static ItemStack create(Material material, String name, int quantity)
	{
		ItemStack i = new ItemStack(material);
		ItemMeta iM = i.getItemMeta();
		iM.setDisplayName(name);
		i.setItemMeta(iM);
		i.setAmount(quantity);
		return i;
	}

	public static ItemStack create(Material material, String name, int quantity, List<String> lore)
	{
		ItemStack i = new ItemStack(material);
		ItemMeta iM = i.getItemMeta();
		iM.setDisplayName(name);
		iM.setLore(lore);
		i.setItemMeta(iM);
		i.setAmount(quantity);
		return i;
	}

	public static ItemStack create(Material material, String name, int quantity, boolean incassable)
	{
		ItemStack i = new ItemStack(material);
		ItemMeta iM = i.getItemMeta();
		iM.setDisplayName(name);
		iM.spigot().setUnbreakable(true);
		i.setItemMeta(iM);
		i.setAmount(quantity);
		return i;
	}

	public static ItemStack create(Material material, String name, int quantity, List<String> lore, boolean incassable)
	{
		ItemStack i = new ItemStack(material);
		ItemMeta iM = i.getItemMeta();
		iM.setDisplayName(name);
		iM.setLore(lore);
		iM.spigot().setUnbreakable(true);
		i.setItemMeta(iM);
		i.setAmount(quantity);
		return i;
	}

	public static ItemStack create(Material material, String name, int quantity, Map enchants)
	{
		ItemStack i = new ItemStack(material);
		ItemMeta iM = i.getItemMeta();
		iM.setDisplayName(name);
		i.setItemMeta(iM);
		i.addEnchantments(enchants);
		i.setAmount(quantity);
		return i;
	}

	public static ItemStack create(Material material, String name, int quantity, List<String> lore, Map enchants)
	{
		ItemStack i = new ItemStack(material);
		ItemMeta iM = i.getItemMeta();
		iM.setDisplayName(name);
		iM.setLore(lore);
		i.setItemMeta(iM);
		i.addEnchantments(enchants);
		i.setAmount(quantity);
		return i;
	}

	public static ItemStack create(Material material, String name, int quantity, boolean incassable, Map enchants)
	{
		ItemStack i = new ItemStack(material);
		ItemMeta iM = i.getItemMeta();
		iM.setDisplayName(name);
		iM.spigot().setUnbreakable(true);
		i.setItemMeta(iM);
		i.addEnchantments(enchants);
		i.setAmount(quantity);
		return i;
	}

	public static ItemStack create(Material material, String name, int quantity, List<String> lore, boolean incassable, Map enchants)
	{
		ItemStack i = new ItemStack(material);
		ItemMeta iM = i.getItemMeta();
		iM.setDisplayName(name);
		iM.setLore(lore);
		iM.spigot().setUnbreakable(true);
		i.setItemMeta(iM);
		i.addEnchantments(enchants);
		i.setAmount(quantity);
		return i;
	}

}
