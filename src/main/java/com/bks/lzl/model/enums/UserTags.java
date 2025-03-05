package com.bks.lzl.model.enums;

public enum UserTags {
    RAIDS(1, "高难"),
    PVP(2, "PVP"),
    FARMING(3, "挂机"),
    TEAMWORK(4, "团队协作"),
    SOLO(5, "单人作战"),
    DUNGEON(6, "副本探险"),
    STRATEGY(7, "策略"),
    CASUAL(8, "休闲"),
    ACHIEVEMENT(9, "成就"),
    CHALLENGE(10, "挑战"),
    LEADERBOARD(11, "排行榜"),
    LOOT(12, "掉落"),
    PVE(13, "PVE"),
    PVE_HARD(14, "PVE-困难"),
    SPEED_RUN(15, "极速通关"),
    BOSS_FIGHT(16, "BOSS战"),
    GUILDS(17, "公会"),
    EVENT(18, "限时活动"),
    STORY_MODE(19, "剧情模式"),
    COOP(20, "合作");
    private int value;
    private String tag;

    UserTags(int value, String tag) {
        this.value = value;
        this.tag = tag;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
