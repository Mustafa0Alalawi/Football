# Football Match Tracker ⚽

A simple Scala program to record and manage football (soccer) match results. The system models matches between clubs and tracks their performance through a small, testable structure.

## Overview

This project includes three main components:

- **Club**: Represents a football club, with its name and statistics.
- **Match**: Represents a football match between two clubs, recording goals and determining the outcome.
- **MatchTest**: An application object used to test the behavior and interaction of the `Club` and `Match` classes.

## How It Works

- Each `Match` is associated with two `Club` instances.
- After a match is played, results (goals scored) are used to determine:
  - Win/loss/draw status
  - Club performance metrics (e.g., points)
- `MatchTest` runs a few example matches and outputs the results for inspection.

## Running the Project

### Requirements

- [Scala](https://www.scala-lang.org/download/)
- [SBT (Scala Build Tool)](https://www.scala-sbt.org/)

### Setup

```bash
git clone https://github.com/Mustafa0Alalawi/Football.git
cd Football
sbt run

```


## Demo
<img width="961" alt="Screenshot 2025-05-13 at 18 37 23" src="https://github.com/user-attachments/assets/aa72a43b-8cae-4d9a-9ffa-6d5d54c09280" />
