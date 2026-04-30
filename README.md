President Trump's 2020 Adventure

Project Overview
This is a text-based strategy game we built for COMP 127. You play as Donald Trump during the last five days of the 2020 election. The setup is that you start in an alternate timeline where you already lost, but you wake up five days before Election Day with a chance to do it over.

Gameplay
You have three stats to keep an eye on:
Support: how much the public and your base are behind you
Stability: how organized your campaign actually is
Mood: basically how angry or calm you are

The game lasts 5 days. Each day has a few parts:
Morning Twitter: You check your phone and react to whatever news just broke. You can play it diplomatic or go full nuclear.

Fixed events: Some stuff just happens no matter what, like debates or press conferences.

Action phase: Pick one thing to do in the afternoon or evening:

Rally: go out and rile up the base

Donors: get support and turn it into immediate support rate

Staff meeting: get your act together, though it usually bums you out
You can't do the same action twice on the same day.

Endings
Depending on where your stats land after Day 5, you get one of four endings:
Victory: high support and stability, you actually win
War: stability crashes and you reject the results
Lose: you lose the election fair and square
Sad: you lose and you're bitter about it

How We Built It
We wrote it in Java with JavaFX for the UI. All the story content lives in nested HashMaps and ArrayLists so we can tweak the narrative without touching the core logic every time.

Main files:
StoryData.java: builds the whole story, the 5-day schedule, the action pool, and all the endings

GameState.java: tracks your current support, stability, and mood

GameController.java: handles your clicks, updates stats, and switches scenes

When the game starts, StoryData.createStory() loads everything into a master map. The UI pulls whatever scene you're on from that map, shows it to you, and when you pick an option it updates your stats and jumps to the next scene. After Day 5 it checks your final numbers against the ending conditions and shows you what happened.

How to Run
You need JDK 11 or newer. Open the project in IntelliJ, Eclipse, or VS Code, find the main class (Main.java or App.java), and run it.

Credits
Made by Ruolin Shen, Tianqi Zhao, and Bridgette Mi for COMP 127 Final Project.

License
This was made for a class. All rights reserved by the authors.