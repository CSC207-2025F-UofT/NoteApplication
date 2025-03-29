# Chess Puzzles

## Team Members

Chihana Kashiwabara - unomaru

Jiaqi Ma - DDMMMAA

Michelle Bakman - 207moment

John Ding - J0hnDing

Yann Chi - YannChi22

## Table of content

+ [About This Project](https://github.com/DDMMMAA/CSC207-Team179?tab=readme-ov-file#about-this-project)
+ [Installation](https://github.com/DDMMMAA/CSC207-Team179?tab=readme-ov-file#installation)
+ [Use Case (Feature)](https://github.com/DDMMMAA/CSC207-Team179?tab=readme-ov-file#use-cases-features)
    + [Signup & Login](https://github.com/DDMMMAA/CSC207-Team179?tab=readme-ov-file#signup--login)
    + [Show Profile](https://github.com/DDMMMAA/CSC207-Team179?tab=readme-ov-file#show-profile)
    + [Generate Daily Puzzle](https://github.com/DDMMMAA/CSC207-Team179?tab=readme-ov-file#generate-daily-puzzle)
    + [Step by Step Move](https://github.com/DDMMMAA/CSC207-Team179?tab=readme-ov-file#generate-daily-puzzle)
+ [Usage Guide](https://github.com/DDMMMAA/CSC207-Team179?tab=readme-ov-file#usage-guide)
+ [Feedback](https://github.com/DDMMMAA/CSC207-Team179?tab=readme-ov-file#feedback)
+ [Contribute to this project](https://github.com/DDMMMAA/CSC207-Team179?tab=readme-ov-file#this-project-is-close-for-contributions)
+ [User Stories](https://github.com/DDMMMAA/CSC207-Team179?tab=readme-ov-file#user-stories)


## About this project

This app/project is able to generate random chess puzzles with options for daily, random puzzles, or specifically themed puzzles.
A user will be able to view their puzzle statistics or review past puzzles within the current session of the program.
Users should have the option to log in or create an account [built into the lichess api].
If a user is logged in, they should be able to access any past puzzle scores or game histories they’ve played on that account.

## Installation

To Start: Clone ```main``` branch into your favorite JAVA IDE, then run ```MainChessAPP.java``` in ```src/main/java/app```
```
git clone https://github.com/DDMMMAA/CSC207-Team179.git
```

To close: Left click ```X``` icon at top right.

Note: No additional package needed

## Use Cases (Features)




### <ins>Signup & Login</ins>

This feature allows users to signup by creating username and password and login to the account created.

To Signup: Enter username and password(two times) to be used for an account, and click ```Signup``` to confirm signup.

To Login: Click ```Login``` to navigate to a login page, enter username and password for the account, and click ```Login``` to confirm login.


### <ins>Show Profile</ins>

User can view their profile (Contain User name and rank point currently) after login by click ```Show Profile``` after login.

Note: New user's rank point is set to ```0``` 

![Show Profile](https://github.com/DDMMMAA/CSC207-Team179/blob/main/Show%20Profilegif.gif?raw=true)


### <ins>Generate daily puzzle</ins>

This requests the algebraic chess notation for the current daily puzzle in the Lichess API
and stores the set of solutions and the series of moves to create the puzzle board.

### <ins>Step by step move</ins>

This feature enables users to move a chess piece to a valid position during their turn. 
Since moving a piece involves two steps, select and move, this usecase have two functionality.

To Select: User clicks on the square containing the chess piece they want to select. The program then highlights all valid moves in yellow.

To Move: If one piece is selected and the user clicks on one of the highlighted squares, the chess piece is moved to the target position.

Note: Clicking an invalid move after select deselects the piece.

## Usage Guide

This meant to me used in order of ```Signup & Login``` &rarr; ```Generate daily puzzle``` &rarr; ```Step by step move```
(Please refer to above ```use cases (Features)``` for detail of each use case)

## Feedback

Plead use github [Discussion board](https://github.com/DDMMMAA/CSC207-Team179/discussions) to submit your feedback.

Simply start a new discussion with appropriate title (eg., associated use case).

## This project is close for contributions

## User Stories

Group User Story. Tom generate a chess puzzle, solve it step by step, and eventually win.

1. John wants to play a chess puzzle. He opens the chess puzzle player and clicks generate puzzle of the day. The chess puzzle of the day loads on screen. [Michelle’s Story]
2. Tom and Tim argued about who is a better chess player, so they decided to compare their Rank point of Ranking system. [Jiaqi Ma’s Story]
3. As Mary hears about this chess puzzle, she wants to create an account and log in to start a puzzle. [Chihana’s Story]
4. Andy is learning chess, and his teacher use this program to check Andy's learning progress, by looking at past statistics of chess puzzles. The teacher can search up Andy's user account using the username. [Yann Chi's Story]
5. Felix wants to see the possible moves he can make with one piece, so he click on that piece and the possible cells will be indicated. [John’s Story]
