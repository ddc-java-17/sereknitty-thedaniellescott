---
title: Current State
description: "Current state of completion, known deficiencies, and test environments used."
menu: State
order: 40
---

{% include ddc-abbreviations.md %}

## Completion state
{: menu="Completion" }

The data structures are more or less complete. The User Interface only has a start, but a good one. An overwhelming amount of my logic is going to be in the UI and repositories. Sereknitty is very much a work in progress.

## Known deficiencies
{: menu="Deficiencies" }

The app has no way to add data except to add it to the database directly. The solution is to finish the Pattern Builder Fragment and its accompanying dialogue fragment that would allow the user to enter in patterns manually.

Sereknitty has a camera button on the Pattern Reader Fragment, but it is not yet capable of allowing users to take pictures of the current pattern in the reader and saving them.

The Pattern Reader's contents are not currently zoomable or interactive. At the moment, what you see is what you get. I also want to set stitch and row labels as one would normally see them on a knitting pattern.

The Pattern Reader does not have a row highlighting feature or a row counting feature. The row counter will be a pair of floating buttons that will increment or decrement what row is highlighted and the current row count as the user taps the appropriate button. I am still sorting out how the row highlighting feature will be implemented.

The Save Current Stitch Location feature has not been implemented in any way shape or form. I hope someday to be able to long press on the stitch I stopped on, have a context menu appear, and select the Save Current Stitch option on said menu.

There is a distinct lack of preferences in this app. I plan to implement a Dark Mode setting (with a series of radio buttons), and a Text Size setting (with a seek bar) for knitters with poor eyesight.

The app has no alternative layout for landscape orientation, but it does rotate just fine as far as I can see. I would still like to add some code to be sure that whatever input the user puts in does not get erased upon rotation (when I implement the Pattern Builder later).



## Test environments used
{: menu="Environments" }

This app has been tested on a Samsung Galaxy S24 phone (Android Version 14, API 34).
