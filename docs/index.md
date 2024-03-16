---
title: Overview
description: "Project proposal or summary of in-progress/completed project."
menu: Overview
order: 0
---

{% include ddc-abbreviations.md %}

## Summary

Sereknitty is an app that makes knitting patterns easier to keep handy on their phone or tablet. It will also allow knitters to input patterns and take pictures of their swatches or projects for their own reference in the future. Sereknitty allows knitters to save exactly what row and stitch they end on when they have to stop knitting.

## Intended users & user stories
{: menu="Users" }

* Moderate to advanced knitters who like to work in complicated patterns like lace or intricate cables.
> As an advanced knitter, I want easy progress tracking on my lace shawl pattern so that I can pick up my knitting right where I left off.

* Knitters who are still learning the ropes.
> As a new knitter, I want easy to access and easy to read patterns for my first lace project.

* Innovative knitters who write patterns
> As a pattern writer, I like to have a pattern builder that I can use to create new patterns and edit patterns I am currently drafting.

## Functionality

* Knitters will be able to access knitting patterns that they put into Sereknitty and see pictures they have taken of their work like a knitting journal or catalogue.
* Zoomable knitting pattern and a togglable key off the side showing what individual stitch symbols mean.
* A counter that one simply has to tap to progress. If the knitter just needs to see the pattern, they can hide or turn off the counting feature.
* Highlight current row and/or stitch in the pattern (also a toggleable feature).
* Save current row and stitch location for later when you have to stop knitting.


## Persistent data
{: menu="Persistence" }

* User
    * Display name
    * OAuth2.0 identifier
    * Timestamp of first login to the app
* Current patterns
  * Current pattern progress (stitch and row coordinates)
  * Which patterns are currently being worked on
* Pictures of patterns
    
## Device/external services
{: menu="Services" }

* Camera
  * https://developer.android.com/media/camera/camerax
  * Sereknitty will allow users to take pictures of their projects and save the picture with their pattern or project.
  * Sereknitty will not require full-time access to the camera to run the app.

## Stretch goals and possible enhancements 
{: menu="Stretch goals" }

* This app could very easily extend to crochet, but since I do not have the expertise in crochet, I am leaving it out. I think it is possible to extend this app's include to knitting machine and knitting loom as well.
* I would like to implement a feature where I can include colors in the pattern input so users can include patterns for color working patterns (EG: Fair Isle knitting).
* I would love to add a feature where one could tap a stitch to see what stitch it is and have a link to a tutorial on how to make this stitch.
* I would like the software to be able to switch between charts and written instructions with ease. Some patterns (EG: circular shawls) are easier to understand with a chart and written instructions, and much of this is to the taste of the individual knitter.
* I like the idea of being able to share patterns with friends.
* I would like to be able to add the ability to upload an image or PDF, have the app look at it, and automatically translate the image to the interactable pattern. This would save users a lot of time and frustration with manual input.