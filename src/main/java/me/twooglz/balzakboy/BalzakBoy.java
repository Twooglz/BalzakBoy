package me.twooglz.balzakboy;

import io.github.cdimascio.dotenv.Dotenv;
import me.twooglz.balzakboy.commands.DeathThreat;
import me.twooglz.balzakboy.commands.KickRetard;
import me.twooglz.balzakboy.eventlisteners.ChannelRenameListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class BalzakBoy {
    private static final Dotenv config = Dotenv.configure().load();
    public static JDA api = JDABuilder.createDefault(config.get("TOKEN")).build();

    public static void main (String[] args) throws InterruptedException {
        api.awaitReady();
        api.addEventListener(new KickRetard(), new DeathThreat(), new ChannelRenameListener());

        api.updateCommands().addCommands(
                Commands.slash("kickmarlon", "kickt marlon"),
                Commands.slash("kickpeter", "kickt peter"),
                Commands.slash("deaththreat", "stuurt deaththreats")
                    .addOption(OptionType.USER, "persoon", "wie moet gedeaththreat worden", true)
        ).queue();

    }
}
