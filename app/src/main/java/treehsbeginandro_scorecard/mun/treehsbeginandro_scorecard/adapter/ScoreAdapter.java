package treehsbeginandro_scorecard.mun.treehsbeginandro_scorecard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import treehsbeginandro_scorecard.mun.treehsbeginandro_scorecard.R;
import treehsbeginandro_scorecard.mun.treehsbeginandro_scorecard.model.Hole;

public class ScoreAdapter extends BaseAdapter {

    private Hole[] mHoles;
    private Context mContext;

    public ScoreAdapter(Context context, Hole[]holes) {
        mHoles = holes;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mHoles.length;
    }

    @Override
    public Object getItem(int i) {
        return mHoles[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View itemView, ViewGroup viewGroup) {
        final ViewHolder viewHolder;

        if (itemView==null){
            itemView = LayoutInflater.from(mContext).inflate(R.layout.list_item,null);

            viewHolder = new ViewHolder();
            viewHolder.mHoleLabel = (TextView) itemView.findViewById(R.id.scoreItemLabelTextView);
            viewHolder.mScoreCount = (TextView) itemView.findViewById(R.id.scoreTextView);
            viewHolder.mSubtractButton = (Button) itemView.findViewById(R.id.subtractButton);
            viewHolder.mAddButton = (Button) itemView.findViewById(R.id.addButton);

            itemView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) itemView.getTag();
        }

        viewHolder.mHoleLabel.setText(mHoles[position].getHoleLabel());
        viewHolder.mScoreCount.setText(mHoles[position].getScore()+"");
        viewHolder.mSubtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ViewHolder vh = (ViewHolder) view.getTag();
                //int currentScore =  new Integer (viewHolder.mScoreCount.getText().toString()).intValue();
                int currentScore = mHoles[position].getScore();
                int newScore=currentScore-1;
                if (newScore<0) newScore = 0;

                viewHolder.mScoreCount.setText(newScore+"");
                mHoles[position].setScore(newScore);
            }
        });

        viewHolder.mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ViewHolder vh = (ViewHolder) view.getTag();
                //int currentScore =  new Integer (viewHolder.mScoreCount.getText().toString()).intValue();
                int currentScore = mHoles[position].getScore();
                int newScore=currentScore+1;

                viewHolder.mScoreCount.setText(newScore+"");
                mHoles[position].setScore(newScore);

            }
        });
        return itemView;
    }

    private static class ViewHolder {
        private TextView mHoleLabel;
        private TextView mScoreCount;
        private Button mSubtractButton;
        private Button mAddButton;
    }
}
