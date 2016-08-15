package treehsbeginandro_scorecard.mun.treehsbeginandro_scorecard;

import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import treehsbeginandro_scorecard.mun.treehsbeginandro_scorecard.adapter.ScoreAdapter;
import treehsbeginandro_scorecard.mun.treehsbeginandro_scorecard.model.Hole;

public class MainActivity extends ListActivity {

    private static final String PACKAGE = "mun.treehsbeginandro_scorecard";
    private static final String PREFS_FILE = PACKAGE + ".PREFS_FILE";
    private static final String KEY_HOLE = "KEY_HOLE";
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    Hole[] mHoles = new Hole[18];
    ScoreAdapter mScoreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        // initialize mHoles array
        int scoreCount =0;
        for (int i=0;i<mHoles.length;i++){
            scoreCount = mSharedPreferences.getInt(KEY_HOLE+i,0);
            mHoles[i] = new Hole("Item "+(i+1), scoreCount);
        }

        mScoreAdapter = new ScoreAdapter(this,mHoles);
        setListAdapter(mScoreAdapter);
    }

    @Override
    protected void onPause() {
        super.onPause();

        for (int i=0;i<mHoles.length;i++){
            mEditor.putInt(KEY_HOLE+i,mHoles[i].getScore());
        }
        mEditor.apply();
    }

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
