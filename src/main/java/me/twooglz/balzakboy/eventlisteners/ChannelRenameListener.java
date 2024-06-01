package me.twooglz.balzakboy.eventlisteners;

import net.dv8tion.jda.api.events.channel.update.ChannelUpdateNameEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ChannelRenameListener extends ListenerAdapter {
    @Override
    public void onChannelUpdateName(ChannelUpdateNameEvent event) {
        if (!event.getChannel().getType().isAudio()) return;
        String channelNameLowerCase = event.getNewValue().toLowerCase();
        if (channelNameLowerCase.contains("lucas")) {
            System.out.println(channelNameLowerCase);
            System.out.println(channelNameLowerCase.replaceAll("lucas", "peter"));
            event.getChannel().asAudioChannel().getManager().setName(channelNameLowerCase.replaceAll("lucas", "peter")).queue();
        }
    }
}