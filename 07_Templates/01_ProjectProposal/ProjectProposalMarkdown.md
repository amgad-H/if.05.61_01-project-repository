


# Requirements and Analyses: Project Proposal -
## Schoolplaner

## Version: 0.1


```
Project leader:	
Amgad Hammash
```

```
Created on	IntelliJ
```
```
Last changed:
```
```
Processing status:	

    x   in process
        submitted
	    completed
```
					

CONTENT
1.  Introduction	4
2.  Initial Situation	5
3.  General Conditions and Constraints	7
4.  Project Objectives and System Concepts	8
5.  Opportunities and Risks	9
6.  Planning	10

## Introduction

Our project focusses on making it easier for students to keep track of their due dates. 
We are planning on using android studio to make this app. 
By daily reminders, an overview of the next deadline-days and also a week and month overview of the schools timetable, 
we want to get a different school planer than the usual ones. 


## Initial Situation

<p>
Current known ways the students use to keep track of their homework are mostly by keeping them in mind, writing them down on a "Homework book" or saving homework on their calendar. But each of these solutions have their own problems. 

Of course simply trying to remember if you have a howework can easily go south once school starts to get stressful. Noting the homework down is smart, until the note is lost or forgotten somewhere and now the student has to rely on remembering what the assignment was, which as we know doesn't always end up good. For the very few students that go through the hassle of setting up colors and titles on their calender so they would notice if they have got homework to do is the problem that they don't keep up with that, ending up with the memory relying students.

Now this is where our app comes into play. It is like an already set up calendar, ready to save your homework in the correct color-code of your WebUntis subjects and to remind you about them before it is too late. The easy input of homework makes it take but seconds and is a quite quality of life improvement. Certain features like the semi-automatic homework inserter will check if atleast one stundent has entered the homework into the calender, then it will enter the homework for the rest of the class into the school planner. This feature will require the assistance of the class representative so that a big group of friends won't jokingly mess around with the input.
<p>


## Conditions and Constraints
<p>
The noting of homework has to be quick and easy, so the student may even do it during the lecture without missing out on the teacher's presentation. It should also remind students in time to decrease amount of missing assignments. 
<p>

### Technical Constraints
<p>
The app should sync with Webuntis and also a backend is necessary to store common events (for the whole class) centrally. Therefore, a dedicated server which is available via the internet has to be installed. An extra feature that might be added is the ability to insert private events in your calendar.
Further on, Webuntis, common class events and personal events have to be merged in one view which is going to be possible by saving those data on a cloud backup service. This way the user wont lose his private events in the case of losing or changing their device.
<p>


### Organisational Constraints
<p>
Userdata, which includes the login information for webuntis and the other events that get added, has to be encrypted.
Our plan is for the app to be accessable only via mobile phone, because students use their phones to enter dates most of the time anyways. From our experience, phones are used more often throughout the day.
<p>

## Project Objectives and System Concepts

<p>
The project’s use case will usually be like this: 
By opening the app the students can see first what they have to do in the next time by a pop up which covers the whole screen.
The Webuntis-Sync helps them plan their whole week or month more easily and by including the timetable, they also would have a much better overview over the canceled hours or the coming school events.

They also can enter their Homework to its respective subject and schedule.
By this, they can easily see if they have homework to do or not, and when a subject is chosen a more informative window will pop up showing exactly what the homework is.

There will be two views. The monthly-view, which will show a clearer overview of project timespans and duedates, and the weekly-view will show the timetable and the homeworks for each subject, this will be visually emphasized. 
<p>
![BluePrint](AppBlueprint.PNG)


## Opportunities and Risks

<p>
The project’s opportunities are:

The App will collab with companies such as Google, Apple and Amazon to make it possible for the Voice Assistants to enter appointment dates easily via voice commands. 
This allows the app to not only be useful for students, but for busy people too, because it can also save shopping lists, making it helpful for adults too.
An easy, straight forward to use app that mixes Notes, Calender and School and/or Work timetable.

Risks to consider:

If webuntis gets outdated too soon this app won't have the chance to take off and develop.
The cloud server the data is saved in may crash or outright stop their service, forcing us to make our own server which is at the moment not possible.
Webuntis and other partaking companies may deny our offer, resulting in big problems, depending what role the company plays in our app.
<p>

## Planning

| Milestones                                                  | Status     | Start date    |
|-------------------------------------------------------------|------------|---------------| 
|Finding and getting comfortable with the working environment | Running... | February 2022 |
|First visual impession of app                                | Ready      | February 2022 |
|Save user input dates                                        | Blocked    | March 2022    |
|Sync with webuntis                                           | Blocked    | July 2022     |
|Saving Notes and Grocery Lists                               | Blocked    | October 2022  |
|Finilzing and refining the app                               | Blocked    | Unknown       |
