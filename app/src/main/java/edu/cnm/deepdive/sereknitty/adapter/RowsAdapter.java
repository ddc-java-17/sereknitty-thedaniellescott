package edu.cnm.deepdive.sereknitty.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import edu.cnm.deepdive.sereknitty.R;
import edu.cnm.deepdive.sereknitty.controller.PatternReaderFragment;
import edu.cnm.deepdive.sereknitty.databinding.ItemRowsBinding;
import edu.cnm.deepdive.sereknitty.model.entity.Row;
import edu.cnm.deepdive.sereknitty.model.pojo.RowWithStitches;
import java.util.List;

/**
 * This {@link Adapter} is the joining element between the data and the view model. This class links
 * {@link RowWithStitches} to the view allowing the {@link PatternReaderFragment} to display a
 * particular row with a particular set of stitches when a pattern is called up.
 */
public class RowsAdapter extends ArrayAdapter<RowWithStitches> {

  private final LayoutInflater inflater;
  private final Context context;

  /**
   * This constructor inflates the layout for the rows that will show in
   * {@link PatternReaderFragment}
   *
   * @param context {@link Context} is the global information from the activity that allows us to
   *                share information across multiple fragments
   * @param rows    The set of {@link Row} that is linked to a particular pattern.
   */
  public RowsAdapter(@NonNull Context context, @NonNull List<RowWithStitches> rows) {
    super(context, R.layout.item_rows, rows);
    inflater = LayoutInflater.from(context);
    this.context = context;
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    RowWithStitches row = getItem(position);
    ItemRowsBinding binding = (convertView != null)
        ? ItemRowsBinding.bind(convertView)
        : ItemRowsBinding.inflate(inflater, parent, false);
    StitchesAdapter adapter = new StitchesAdapter(context, row.getStitches());
    binding.getRoot().setAdapter(adapter);
    return binding.getRoot();
  }

}
