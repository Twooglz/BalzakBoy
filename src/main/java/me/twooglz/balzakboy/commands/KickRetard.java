package me.twooglz.balzakboy.commands;

import me.twooglz.balzakboy.Main;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class KickRetard extends ListenerAdapter {
    long lastUseTime = System.currentTimeMillis();
    int cooldownMillis = 30000;
    String id;
    String naam;

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("kickmarlon")) {
            id = "781197207554490399";
            naam = "Marlon";
        } else if (event.getName().equals("kickpeter")) {
            id = "426427701528887317";
            naam = "Peter";
        } else {
            return;
        }
        long timeSinceLastUse = System.currentTimeMillis() - lastUseTime;
        if (timeSinceLastUse <= cooldownMillis) {
            event.reply(String.format("Cooldown!!! (%.1fs)",(float) (cooldownMillis - timeSinceLastUse)/1000)).setEphemeral(true).queue();
            return;
        }


        try {
            event.getGuild().moveVoiceMember(event.getGuild().getMember(Main.api.getUserById(id)), null).queue();
            event.reply(naam + " is weg").setEphemeral(true).queue();
            lastUseTime = System.currentTimeMillis();
        } catch (IllegalArgumentException e) {
            event.reply(naam + " is nie eens in call retard").setEphemeral(true).queue();
        }
    }
}
