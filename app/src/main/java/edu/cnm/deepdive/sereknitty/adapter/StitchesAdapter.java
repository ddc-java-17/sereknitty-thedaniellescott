package edu.cnm.deepdive.sereknitty.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import edu.cnm.deepdive.sereknitty.R;
import edu.cnm.deepdive.sereknitty.model.Stitch;
import java.util.List;

/**
 * This {@link android.widget.Adapter} is the joining element between the data and the view model.
 * This class links {@link Stitch} to the
 */
public class StitchesAdapter extends ArrayAdapter<Stitch> {

  private final LayoutInflater inflater;

  /**
   *
   *
   * @param context
   * @param stitches
   */
  public StitchesAdapter(@NonNull Context context, @NonNull List<Stitch> stitches) {
    super(context, R.layout.item_stitches, stitches);
    inflater = LayoutInflater.from(context);
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    return super.getView(position, convertView, parent);
  }

}
