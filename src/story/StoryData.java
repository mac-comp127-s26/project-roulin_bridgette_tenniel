package story;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class StoryData {
    private StoryData() {
    }

    public static Map<String, Object> createStory() {
        Map<String, Object> story = new HashMap<>();

        story.put("title", "President Trump's 2020 Adventure News");

        List<Map<String, Object>> days = new ArrayList<>();
        
        // --- DAY 1: The Morning Twitter Briefing ---
        Map<String, Object> day1 = new HashMap<>();
        day1.put("dayNumber", 1);
        day1.put("dayTitle", "The Morning Twitter Briefing");
        
        List<Map<String, Object>> day1Events = new ArrayList<>();

        // News Event 1: The Chris Wallace Cognitive Test Interview
        Map<String, Object> news1 = new HashMap<>();
        news1.put("title", "News Event 1: The Cognitive Test");
        news1.put("news", "Waking up, you see Fox News anchor Chris Wallace on TV claiming that the Montreal Cognitive Assessment you took wasn't actually that hard, and that the last few questions literally just involved identifying a picture of an elephant.");
        news1.put("optionA", "Express an opinion: Boast about your undeniably massive intellect and flawless memory.");
        news1.put("reactionA", "You squint at the TV in absolute disgust at the fake news. You type: 'Chris Wallace is nasty and obnoxious! The doctors were amazed, they said nobody ever gets it in order, but I did: Person, Woman, Man, Camera, TV. Total genius!'");
        news1.put("optionB", "No reaction: Pretend you didn't hear him, slowly tap your temple knowingly, and hit the red button on your desk for a fresh Diet Coke to fuel your giant brain.");
        news1.put("optionC", "Funny: Immediately draft an Executive Order mandating that the SATs be completely replaced by a test where students just have to accurately point to an elephant.");
        day1Events.add(news1);

        // News Event 2: Mount Rushmore Addition Rumors
        Map<String, Object> news2 = new HashMap<>();
        news2.put("title", "News Event 2: Mount Rushmore");
        news2.put("news", "Today's morning outrage is a leaked report from the failing New York Times claiming that your administration officially reached out to South Dakota Governor Kristi Noem to ask about the process of carving your face into Mount Rushmore.");
        news2.put("optionA", "Express an opinion: Deny you asked, but strongly agree that you completely deserve it.");
        news2.put("reactionA", "You shake your head at how ungrateful the media is for your tremendous achievements. You tweet: 'This is Fake News by the failing NYT! Never suggested it although, based on all of the many things accomplished during the first 3 1/2 years, perhaps more than any other Presidency, sounds like a good idea to me!'");
        news2.put("optionB", "No reaction: Leave the news on read, but secretly stand in front of the Oval Office mirror practicing your most stoic, granite-like facial expression just in case.");
        news2.put("optionC", "Funny: Dispatch the Army Corps of Engineers to South Dakota with strict instructions to ensure your stone hair is carved significantly taller and more beautiful than George Washington's.");
        day1Events.add(news2);

        // News Event 3: The $750 Tax Bombshell
        Map<String, Object> news3 = new HashMap<>();
        news3.put("title", "News Event 3: The $750 Taxes");
        news3.put("news", "You open Twitter to absolute chaos because the New York Times just dropped a massive 'bombshell' claiming that you, a supposed billionaire, only paid exactly $750 in federal income taxes during your first year in the White House.");
        news3.put("optionA", "Express an opinion: Educate the absolute losers on how brilliant business depreciation works.");
        news3.put("reactionA", "You aggressively stab your phone screen with your thumb to defend your incredible wealth. You tweet: 'The Fake News Media, just like Election time 2016, is bringing up my Taxes & all sorts of nonsense. I paid millions, and I am entitled to depreciation & tax credits! I am the only President to give up my salary!'");
        news3.put("optionB", "No reaction: Refuse to care, tell Melania that paying taxes is for people with low IQs, and go back to watching Fox & Friends.");
        news3.put("optionC", "Funny: Instruct Treasury Secretary Steve Mnuchin to officially mint a new, gold-plated $750 coin with your face on it, exclusively to be used by you to pay the IRS.");
        day1Events.add(news3);

        // News Event 4: The Walter Reed SUV Joyride
        Map<String, Object> news4 = new HashMap<>();
        news4.put("title", "News Event 4: The SUV Joyride");
        news4.put("news", "Checking your phone from your Walter Reed hospital bed while being treated for COVID-19, you see the media crying because you took a brief, airtight SUV drive-by to wave at your fans, with doctors claiming you endangered the Secret Service agents inside.");
        news4.put("optionA", "Express an opinion: Shame the media for hating your beautiful relationship with your supporters.");
        news4.put("reactionA", "You take a deep breath of premium medical oxygen and prepare to destroy the haters. You tweet: 'Media is upset because I got into a secure vehicle to say thank you to the many fans outside! If I didn't do it, they would say I was rude. It is reported that the Media is upset because I went to say hello!'");
        news4.put("optionB", "No reaction: Ignore the complaints, grab a black Sharpie, and sign your name on a completely blank piece of printer paper so the White House photographer can show how hard you are working.");
        news4.put("optionC", "Funny: Command the Secret Service to literally roll the heavy armored presidential SUV directly into the Walter Reed lobby and drive you down the hospital corridors so you don't have to walk to the bathroom.");
        day1Events.add(news4);

        // News Event 5: The Fly on Mike Pence's Head
        Map<String, Object> news5 = new HashMap<>();
        news5.put("title", "News Event 5: The Debate Fly");
        news5.put("news", "Waking up the morning after the Vice Presidential debate, the number one trending topic globally isn't Mike Pence destroying Kamala Harris, but a literal giant black fly that sat directly on Pence’s bright white hair for exactly two undisturbed minutes.");
        news5.put("optionA", "Express an opinion: Pivot the conversation back to how terrible the Democrats are.");
        news5.put("reactionA", "You refuse to let a bug steal your administration's spotlight. You tweet: 'Mike Pence won BIGly! Kamala was completely unwatchable, nasty, and couldn't even answer simple questions. Nobody cares about a bug, they care about LAW AND ORDER!'");
        news5.put("optionB", "No reaction: Pretend the fly incident never happened, but mentally demote Pence's hairspray coordinator for the rest of the campaign.");
        news5.put("optionC", "Funny: Send an urgent, all-caps email to your campaign manager demanding an immediate federal investigation into whether the fly was a listening device planted by the Radical Left and ANTIFA.");
        day1Events.add(news5);

        // Add the events to Day 1, and Day 1 to the Story
        day1.put("events", day1Events);
        days.add(day1);
        
        story.put("days", days);
        story.put("endings", new ArrayList<Map<String, Object>>());

        return story;
    }
}