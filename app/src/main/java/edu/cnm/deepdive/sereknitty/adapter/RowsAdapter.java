package edu.cnm.deepdive.sereknitty.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import edu.cnm.deepdive.sereknitty.R;
import edu.cnm.deepdive.sereknitty.model.Row;
import edu.cnm.deepdive.sereknitty.model.entity.RowStitch;
import java.util.List;

public class RowsAdapter extends ArrayAdapter<Row> {

  private final LayoutInflater inflater;

  public RowsAdapter(@NonNull Context context, @NonNull List<Row> rows) {
    super(context, R.layout.item_rows, rows);
    inflater = LayoutInflater.from(context);
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
     Row row = getItem(position);
     List<RowStitch> stitches = row.
  }
}
