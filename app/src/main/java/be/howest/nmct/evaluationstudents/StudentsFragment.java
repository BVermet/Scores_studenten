package be.howest.nmct.evaluationstudents;

import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


import java.text.DecimalFormat;

import be.howest.nmct.evaluationstudents.loader.Contract;
import be.howest.nmct.evaluationstudents.loader.StudentsLoader;


public class StudentsFragment extends ListFragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private StudentAdapter myStudentAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] columns = new String[]{
                Contract.StudentColumns.COLUMN_STUDENT_NAAM,
                Contract.StudentColumns.COLUMN_STUDENT_VOORNAAM,
                Contract.StudentColumns.COLUMN_STUDENT_EMAIL,
                Contract.StudentColumns.COLUMN_STUDENT_SCORE_TOTAAL
        };

        int[] viewIds = new int[]{
                R.id.txtAchternaam,
                R.id.txtVoornaam,
                R.id.txtEmail,
                R.id.txtScore
        };

        myStudentAdapter = new StudentAdapter(getActivity(),
                R.layout.row_student,
                null,
                columns,
                viewIds,
                0);
        setListAdapter(myStudentAdapter);

        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new StudentsLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        myStudentAdapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        myStudentAdapter.swapCursor(null);
    }

    class StudentAdapter extends SimpleCursorAdapter {

        public StudentAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
            super(context, layout, c, from, to, flags);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            super.bindView(view, context, cursor);

            ImageView icon = (ImageView) view.findViewById(R.id.imgStudent);

            int colNr = cursor.getColumnIndex(Contract.StudentColumns.COLUMN_STUDENT_SCORE_TOTAAL);
            double score = cursor.getDouble(colNr);

            DecimalFormat df = new DecimalFormat("##.00");

            TextView txtTotaalScore = (TextView) view.findViewById(R.id.txtScore);
            txtTotaalScore.setText(df.format(score));

            if(score < 8){
                icon.setImageResource(R.drawable.student_red);
            } else if(score <10){
                icon.setImageResource(R.drawable.student_orange);
            } else {
                icon.setImageResource(R.drawable.student_green);
            }
        }
    }

}
