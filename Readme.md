# Golf Scorecard App - `SharedPreferences`
## About this app

This android app is part of Treehouse Beginners Android Dev track

- It demos *SharedPreferences*
- ListActivity displays a list of 18 Holes and user has + and - buttons to increase or decrease the golf score.
- ListActivity uses its standard ListAdapter that binds an array of Holes[18] tot he list view
- The score of each hole is added to SharedPreferences during `onPause` method and retrieved from SharedPreferences during `onCreate` method
- App also uses a main menu with just one menu item "Clear Score" that resets all scores to zero. See `menu_main.xml` file for xml layout for the menu

## SharedPreferences code

```java
public class MainActivity extends ListActivity {

    ...
    ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ...
        ...

        mSharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        ...
        ...
    }

    @Override
    protected void onPause() {
        super.onPause();

        for (int i=0;i<mHoles.length;i++){
            mEditor.putInt(KEY_HOLE+i,mHoles[i].getScore());
        }
        mEditor.apply();
    }
...
...

}
```

## Options Menu Code to clear Score count
```java
public class MainActivity extends ListActivity {

...
...

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_clear_strokes) {

            mEditor.clear().apply(); //chaining clear and then apply methods

            for (Hole hole:mHoles){
                hole.setScore(0);
            }

            mScoreAdapter.notifyDataSetChanged();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
```

