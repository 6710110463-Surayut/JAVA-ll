import java.util.*;

public class QuestService {
    public ArrayList<Quest> quests = new ArrayList<>();
    public HashMap<String, Integer> stats = new HashMap<>();

    public QuestService() {
        stats.put("completed", 0);
        stats.put("failed", 0);
    }

    public void seedQuests(int key) {
        quests.add(new DailyQuest("D-" + key + "-1", "Scan Tools", (key % 5) + 1));
        quests.add(new DailyQuest("D-" + key + "-2", "Clean Data", ((key + 1) % 5) + 1));
        quests.add(new DailyQuest("D-" + key + "-3", "Refactor", ((key + 2) % 5) + 1));
        quests.add(new StoryQuest("S-" + key + "-1", "Decrypt", ((key + 3) % 5) + 1));
        quests.add(new StoryQuest("S-" + key + "-2", "Escape", ((key + 4) % 5) + 1));
        quests.add(new StoryQuest("S-" + key + "-3", "Boss fight", ((key + 5) % 5) + 1));
    }

    public Quest findById(String id) throws QuestException {
        for (Quest q : quests) {
            if (q.getId().equalsIgnoreCase(id)) return q;
        }
        throw new QuestException("ไม่พบเควสต์ ID: " + id);
    }

    public void listQuests() {
        for (Quest q : quests) System.out.println(q.toString());
    }
}