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
public final class StoryDataPart2 {
    private StoryDataPart2() {
    }

    public static Map<String, Object> createMidGameContent() {
        Map<String, Object> gameContent = new HashMap<>();

        // ==========================================
        // PART 1: DAILY ACTIVITIES POOL (For Days 2, 3, 5)
        // ==========================================
        Map<String, List<Map<String, Object>>> activitiesPool = new HashMap<>();

        // Category A: Campaign Rallies (Real 2020 events, 2 actions each)
        List<Map<String, Object>> rallies = new ArrayList<>();
        
        Map<String, Object> rally1 = new HashMap<>();
        rally1.put("event", "Tulsa Rally (June 20, 2020): You spend 15 minutes of your speech meticulously explaining why you walked slowly down a ramp, and complaining that the fake news said you couldn't drink water.");
        rally1.put("actionA", "Drink a glass of water with one hand to prove you are perfectly healthy.");
        rally1.put("effectA_support", 1);
        rally1.put("actionB", "Drink the water and aggressively toss the glass away to wild cheers, showing absolute physical dominance.");
        rally1.put("effectB_support", 2);
        rallies.add(rally1);

        Map<String, Object> rally2 = new HashMap<>();
        rally2.put("event", "Sanford, FL Rally (Oct 12, 2020): Freshly recovered from COVID-19, you tell the crowd you feel so powerful that you could walk into the audience and kiss everyone, including the men.");
        rally2.put("actionA", "Toss some beautiful MAGA hats into the crowd to show you are feeling great.");
        rally2.put("effectA_support", 1);
        rally2.put("actionB", "Dance awkwardly but enthusiastically to the song 'Y.M.C.A.' to prove you have tremendous, limitless energy.");
        rally2.put("effectB_support", 2);
        rallies.add(rally2);

        Map<String, Object> rally3 = new HashMap<>();
        rally3.put("event", "Lansing, MI Rally (Oct 27, 2020): It is freezing cold outside, and you complain to the massive crowd that the fake news made you stand out in the wind.");
        rally3.put("actionA", "Complain about the freezing wind and remind them that you are only suffering because you love them.");
        rally3.put("effectA_support", 1);
        rally3.put("actionB", "Let the crowd passionately chant 'We Love You!' while you bask in the freezing glory of their devotion.");
        rally3.put("effectB_support", 2);
        rallies.add(rally3);
        
        activitiesPool.put("Rallies", rallies);

        // Category B: Meeting Donors (Real 2020 events, no actions, just +1 Support)
        List<Map<String, Object>> donors = new ArrayList<>();
        
        Map<String, Object> donor1 = new HashMap<>();
        donor1.put("event", "Hamptons Fundraiser (Aug 9, 2020): You raise $15 million from billionaires while complaining to them that modern washing machines don't use enough water to get clothes wet.");
        donor1.put("effect_support", 1);
        donors.add(donor1);

        Map<String, Object> donor2 = new HashMap<>();
        donor2.put("event", "Bedminster Fundraiser (Oct 1, 2020): You host an elite indoor fundraiser at your New Jersey golf club, raising millions just hours before testing positive for the virus. A tremendous success.");
        donor2.put("effect_support", 1);
        donors.add(donor2);

        Map<String, Object> donor3 = new HashMap<>();
        donor3.put("event", "Beverly Hills Fundraiser (Oct 18, 2020): You meet with tech billionaire Palmer Luckey in California to secure millions in donations, proving even the liberal west coast loves you.");
        donor3.put("effect_support", 1);
        donors.add(donor3);

        activitiesPool.put("Donors", donors);

        // Category C: Meeting Staff (Real 2020 events, no actions, just +1 Stability)
        List<Map<String, Object>> staffMeetings = new ArrayList<>();
        
        Map<String, Object> staff1 = new HashMap<>();
        staff1.put("event", "Oval Office Goya Meeting (July 15, 2020): You gather your top staff in the Oval Office to proudly pose with five different cans of Goya beans lined up on the Resolute Desk.");
        staff1.put("effect_stability", 1);
        staffMeetings.add(staff1);

        Map<String, Object> staff2 = new HashMap<>();
        staff2.put("event", "Rose Garden Nomination (Sept 26, 2020): You shake hands with dozens of staff and senators to celebrate Amy Coney Barrett, completely ignoring masks because everyone is just so happy.");
        staff2.put("effect_stability", 1);
        staffMeetings.add(staff2);

        Map<String, Object> staff3 = new HashMap<>();
        staff3.put("event", "Walter Reed SUV Planning (Oct 4, 2020): You shake hands with Chief of Staff Mark Meadows to plan your airtight SUV joyride around the hospital to wave at your beautiful fans.");
        staff3.put("effect_stability", 1);
        staffMeetings.add(staff3);

        activitiesPool.put("Staff", staffMeetings);
        gameContent.put("DailyActivitiesPool", activitiesPool);


        // ==========================================
        // PART 2: PRESS CONFERENCES (Fixed for Days 2 & 4)
        // ==========================================
        List<Map<String, Object>> pressConferences = new ArrayList<>();

        // Press Conf 1: The Disinfectant Briefing (April 23, 2020)
        Map<String, Object> press1 = new HashMap<>();
        press1.put("event", "White House Briefing: A very nasty reporter asks if you seriously think injecting bleach or using ultraviolet light inside the body is a good idea to cure the virus.");
        press1.put("actionA", "Answer vaguely: Suggest they should look into UV light and cleaning the lungs, it sounds interesting.");
        press1.put("effectA_stability", -1);
        press1.put("effectA_support", -1);
        press1.put("actionB", "Answer directly: Turn to Dr. Birx on live TV and loudly ask her if she can figure out how to put light inside the human body.");
        press1.put("effectB_stability", -2);
        press1.put("effectB_support", -2);
        press1.put("actionC", "Refuse to answer: 'You are a terrible reporter, that's a fake news question, get out!'");
        pressConferences.add(press1);

        // Press Conf 2: Peaceful Transfer of Power (Sept 23, 2020)
        Map<String, Object> press2 = new HashMap<>();
        press2.put("event", "White House Briefing: A reporter asks if you will commit to a peaceful transfer of power after the election, regardless of who wins.");
        press2.put("actionA", "Answer vaguely: 'We're going to have to see what happens, you know that I've been complaining very strongly about the ballots.'");
        press2.put("effectA_stability", -1);
        press2.put("effectA_support", -1);
        press2.put("actionB", "Answer directly: 'Get rid of the ballots and there won't be a transfer, frankly, there will be a continuation.'");
        press2.put("effectB_stability", -2);
        press2.put("effectB_support", -2);
        press2.put("actionC", "Refuse to answer: 'I'm not answering that, you are the enemy of the people. Fake News!'");
        pressConferences.add(press2);

        gameContent.put("PressConferences", pressConferences);


        // ==========================================
        // PART 3: PRESIDENTIAL DEBATE (Standalone Ending/Plot)
        // ==========================================
        Map<String, Object> presidentialDebate = new HashMap<>();
        presidentialDebate.put("intro", "September 29, 2020. You walk onto the debate stage in Cleveland. Sleepy Joe is standing at his podium. The moderator asks the first question, but you completely tune out whatever Joe is saying.");
        
        List<Map<String, String>> debateDialogue = new ArrayList<>();
        
        // Round 1
        Map<String, String> round1 = new HashMap<>();
        round1.put("Biden", "⏚⍙⌰⌰⌇⊑⟟⏁ ⋔⏃⌰⏃⍀☍⊬ ⟟ ⏃⋔ ⏁⊑⟒ ⎅⟒⋔⍜☊⍀⏃⏁⟟☊ ⌿⏃⍀⏁⊬ ⋏⍜⍙!");
        round1.put("Trump_Response", "I brought back Big Ten college football, Joe. You've been in there 47 years and done absolutely nothing!");
        debateDialogue.add(round1);

        // Round 2
        Map<String, String> round2 = new HashMap<>();
        round2.put("Biden", "⍙⟟⌰⌰ ⊬⍜⎍ ⌇⊑⎍⏁ ⎍⌿ ⋔⏃⋏ ☊⍜⋔⟒ ⍜⋏ ⋔⏃⋏...");
        round2.put("Trump_Response", "There is nothing smart about you, Joe. Don't ever use the word smart with me, okay?");
        debateDialogue.add(round2);

        // Round 3
        Map<String, String> round3 = new HashMap<>();
        round3.put("Biden", "⌰⟟⏁⟒⍀⏃⌰⌰⊬ ⟟⋏⊑⏃⌰⟟⋏☌ ⏃⋏⎅ ⋏⍜⏁ ⟒⌖⊑⏃⌰⟟⋏☌ ⏃⏁ ⏃⌰⌰!!");
        round3.put("Trump_Response", "Stand back and stand by! Frankly, I answered perfectly, and I won this debate by a lot!");
        debateDialogue.add(round3);

        presidentialDebate.put("dialogue", debateDialogue);
        
        // Ending Sequence
        presidentialDebate.put("ending", "The debate ends in total chaos. Fast forward to November: the fake news networks project Joe Biden as the winner. RIGGED ELECTION! You have been defeated by Sleepy Joe (and a massive dump of mail-in ballots). Game Over!");
        
        gameContent.put("PresidentialDebateSequence", presidentialDebate);

        return gameContent;
    }
}