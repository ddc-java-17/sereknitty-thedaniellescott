package edu.cnm.deepdive.sereknitty.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import edu.cnm.deepdive.sereknitty.R;
import edu.cnm.deepdive.sereknitty.databinding.ItemRowsBinding;
import edu.cnm.deepdive.sereknitty.model.RowWithStitches;
import edu.cnm.deepdive.sereknitty.model.entity.Row;
import java.util.List;

public class RowsAdapter extends ArrayAdapter<RowWithStitches> {

  private final LayoutInflater inflater;

  public RowsAdapter(@NonNull Context context, @NonNull List<RowWithStitches> rows) {
    super(context, R.layout.item_rows, rows);
    inflater = LayoutInflater.from(context);
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    RowWithStitches row = getItem(position);
    ItemRowsBinding binding = (convertView != null)
        ? ItemRowsBinding.bind(convertView)
        : ItemRowsBinding.inflate(inflater, parent, false);
    // TODO: 3/30/2024  create an instance of StitchesAdapter, pass to it in the constructor the
    //  context, the list of rowStitches that we get from row.getStitches.
//    binding.getRoot().setAdapter();
    return binding.getRoot();
  }
}
