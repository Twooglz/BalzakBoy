package me.twooglz.balzakboy.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.text.MessageFormat;
import java.util.Random;

public class DeathThreat extends ListenerAdapter {
    String[] deathThreats = {
        "{0} kys",
        "{0} kill uzelf",
        "{0} vermoord uzelf",
        "{0} ga 0/1 irl",
        "{0} ik hoop da u fucking familie recht voor u ogen verbrand word",
        "ik ga {0} doodslaan",
        "{0} de wereld zou verbeteren als ge een kogel door u kop zou schieten",
        "als ik in een kamer zat met hitler, kim jong un, en {0} en ik een pistool met twee kogels had zou ik {0} twee keer schieten",
        "{0} is een fucking kanker kind en {0} moet echt dringend zichzelf vermoorden",
        "{0}, ik wil je herinneren dat zelfmoord altijd een optie is",
        "{0} ga op google en zoek voor de dichtstbijzijnde brug en spring er vanaf",
        "{0} HINT KIJK OP DEZE WEBSITE ---> https://en.wikipedia.org/wiki/Suicide_pill",
        "{0} vergeet niet in het leven als iemand zegt \"je bent waardevol\" en \"je hebt nut\" dat ze liegen tegen je en je moet eigenlijk gewoon zelfmoord plegen",
        "{0} KANKER KIND PLEEG ZELFMOORD",
        "{0} ga dood"
    };


    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("deaththreat")) return;
        String id = event.getOption("persoon").getAsMember().getId();
        event.reply(MessageFormat.format(getRandom(deathThreats), "<@" + id + ">")).queue();
    }

    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}
