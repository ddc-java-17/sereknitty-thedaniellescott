---
title: Overview
description: "Project proposal or summary of in-progress/completed project."
menu: Overview
order: 0
---

{% include ddc-abbreviations.md %}

## Summary

Sereknitty is an app that makes knitting patterns easier to keep handy on their phone or tablet. It will also allow knitters to input patterns and take pictures of their swatches or projects for their own reference in the future. Sereknitty lead knitters to tutorials on new stitches, and allow knitters to save exactly what row and stitch they ended on when they have to stop knitting.

## Intended users & user stories
{: menu="Users" }

* Moderate to advanced knitters who like to work in complicated patterns like lace.
> As an advanced knitter, I want easy progress tracking on my lace shawl pattern so that I can pick up my knitting right where I left off.

* Knitters who are still learning the ropes.
>As a new knitter, I want ease of access to tutorials for new stitches in my pattern so that I can spend more time knitting instead of searching for stitch tutorials. 

## Functionality

* Knitters will be able to access knitting patterns that they put into Sereknitty and see pictures they have taken of their work like a knitting journal or catalogue. Inputs for color work and lace patterns.
* Interactable and zoomable knitting pattern that allows the knitter to tap and hold for stitch information and tutorial.
* A counter that one simply has to tap to progress. If the knitter just needs to see the pattern, they can hide or turn off the counting feature.
* Highlight current row and/or stitch in the pattern (also a togglable feature).
* Save current row and stitch location for later when you have to stop knitting.


## Persistent data
{: menu="Persistence" }

* User
    * Display name
    * OAuth2.0 identifier
    * Timestamp of first login to the app
* Current (or all preferably) patterns
  * Current pattern progress (stitch and row coordinates)
* Pictures of patterns
    
## Device/external services
{: menu="Services" }

* Camera
* Gallery
* Internet

## Stretch goals and possible enhancements 
{: menu="Stretch goals" }

* This app could very easily extend to crochet, but since I do not have the expertise in crochet, I am leaving it out. It is possible that knitting machine and knitting loom users could find use for an app like this as well, but I know less about these than I know about crochet.
* I could film my own tutorial videos to bypass potential licensing issues, however, I do not have that kind of time, or the aesthetically pretty hands for the job.
* I would like the software to be able to switch between charts and written instructions with ease. Some patterns (EG: circular shawls) are easier to understand with a chart and written instructions, and much of this is to the taste of the individual knitter.
* I like the idea of being able to share patterns with friends, but I am a solo knitter and I have no idea if other knitters would be interested in this feature.
* I would like to be able to add the ability to upload an image or PDF, have the app look at it, and automatically translate the image to the interactable pattern. This would save users a lot of time and frustration with manual input, but with my skill and resources, I am not sure it is possible.