

// By Curiosow

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class TextComponentGUI {

	public static TextComponent createText(String message)
	{
		TextComponent tc = new TextComponent(message);
		return tc;
	}

	public static TextComponent createTextCmd(String message, String command, String hollowText)
	{
		TextComponent tc = new TextComponent(message);
		tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, command));
		tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(hollowText).create()));
		return tc;
	}

	public static TextComponent createTextCmd(String message, String command)
	{
		TextComponent tc = new TextComponent(message);
		tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, command));
		return tc;
	}

	public static TextComponent createTextSite(String message, String url, String hollowText)
	{
		TextComponent tc = new TextComponent(message);
		tc.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, url));
		tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(hollowText).create()));
		return tc;
	}

	public static TextComponent createTextSite(String message, String url)
	{
		TextComponent tc = new TextComponent(message);
		tc.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, url));
		return tc;
	}

	public static TextComponent createTextPreCmd(String message, String command, String hollowText)
	{
		TextComponent tc = new TextComponent(message);
		tc.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, command));
		tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(hollowText).create()));
		return tc;
	}

}
