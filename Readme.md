# Golf Scorecard App - `SharedPreferences`
## About this app

This android app is part of Treehouse Beginners Android Dev track

It demos *SharedPreferences*

ListActivity displays a list of 18 Holes and user has + and - buttons to increase or decrease the golf score.

ListActivity uses its standard ListAdapter that binds an array of Holes[18] tot he list view

The score of each hole is added to SharedPreferences during `onPause` method and retrieved from SharedPreferences during `onCreate` method

