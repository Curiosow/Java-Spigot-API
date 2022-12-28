

// By Gelox_

import javax.net.ssl.HttpsURLConnection;
import java.io.OutputStream;
import java.net.URL;

public class DiscordWebhookAnnonces {

    public static void execute(String json) {
        ///////////////////////////////////////////////
        // CONFIG
        String tokenWebhook = "INSERT HERE YOUR TOKEN";
        ///////////////////////////////////////////////

        String newJsonBrut = "";
        newJsonBrut += json;

        try {
            URL url = new URL(tokenWebhook);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.addRequestProperty("Content-Type", "application/json");
            con.addRequestProperty("User-Agent", "Java-DiscordWebhook-BY-Gelox_");
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            OutputStream stream = con.getOutputStream();
            stream.write(newJsonBrut.getBytes());
            stream.flush();
            stream.close();
            con.getInputStream().close();
            con.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
