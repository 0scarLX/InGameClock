package net.clustlight.spigot.ingameclock;

import net.clustlight.spigot.ingameclock.clocks.TopBarClock;
import net.clustlight.spigot.ingameclock.clocks.ScoreBoardClock;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Score;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UpdateTask extends BukkitRunnable {

    @Override
    public void run() {

        LocalDateTime d = LocalDateTime.now();
        double j = d.getSecond();
        String bar_data = DateTimeFormatter.ofPattern(InGameClockConfig.get().getString("[settings].Bar.TimeFormat")).format(d);
        String score_data = DateTimeFormatter.ofPattern(InGameClockConfig.get().getString("[settings].Score.TimeFormat")).format(d);

        // Get previous data to remove it
        String previous_data1 = DateTimeFormatter.ofPattern(InGameClockConfig.get().getString("[settings].Score.TimeFormat")).format(d.minusSeconds(1));
        String previous_data2 = DateTimeFormatter.ofPattern(InGameClockConfig.get().getString("[settings].Score.TimeFormat")).format(d.minusSeconds(2));
        String previous_data3 = DateTimeFormatter.ofPattern(InGameClockConfig.get().getString("[settings].Score.TimeFormat")).format(d.minusSeconds(3));
        String previous_data4 = DateTimeFormatter.ofPattern(InGameClockConfig.get().getString("[settings].Score.TimeFormat")).format(d.minusSeconds(4));
        String previous_data5 = DateTimeFormatter.ofPattern(InGameClockConfig.get().getString("[settings].Score.TimeFormat")).format(d.minusSeconds(5));

        // Update Process for TopBarClock
        String bf = InGameClockConfig.get().getString("[settings].Bar.Formatting");
        TopBarClock.bar.setTitle(bf + bar_data);
        TopBarClock.bar.setProgress(j/(double) 60);

        // Update Process for ScoreBoardClock
        String sf = InGameClockConfig.get().getString("[settings].Score.Formatting");
        ScoreBoardClock.scoreboard.resetScores(sf + previous_data1);
        ScoreBoardClock.scoreboard.resetScores(sf + previous_data2);
        ScoreBoardClock.scoreboard.resetScores(sf + previous_data3);
        ScoreBoardClock.scoreboard.resetScores(sf + previous_data4);
        ScoreBoardClock.scoreboard.resetScores(sf + previous_data5);
        Score score = ScoreBoardClock.objective.getScore(sf + score_data);
        score.setScore(0);
    }
}
