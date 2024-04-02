package edu.cnm.deepdive.sereknitty.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import edu.cnm.deepdive.sereknitty.R;
import edu.cnm.deepdive.sereknitty.controller.PatternReaderFragment;
import edu.cnm.deepdive.sereknitty.databinding.ItemStitchesBinding;
import edu.cnm.deepdive.sereknitty.model.Stitch;
import edu.cnm.deepdive.sereknitty.model.entity.RowStitch;
import java.util.Arrays;
import java.util.List;

/**
 * This {@link Adapter} is the joining element between the data and the view model. This class links
 * {@link Stitch} to the view model dealing with {@link PatternReaderFragment}.
 */
public class StitchesAdapter extends ArrayAdapter<RowStitch> {

  private final LayoutInflater inflater;
  private final Drawable[] drawables;

  /**
   * This constructor inflates the layout for the individual stitches that will show in
   * {@link PatternReaderFragment}.
   *
   * @param context  {@link Context} is the global information from the activity that allows us to
   *                 share information across multiple fragments
   * @param stitches {@link List} of {@link RowStitch} objects that link to the {@link Enum}
   *                 {@link Stitch}
   */
  public StitchesAdapter(@NonNull Context context, @NonNull List<RowStitch> stitches) {
    super(context, R.layout.item_stitches, stitches);
    inflater = LayoutInflater.from(context);
    drawables = Arrays.stream(Stitch.values())
        .map((stitch) -> ContextCompat.getDrawable(context, stitch.getImage()))
        .toArray(Drawable[]::new);
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    RowStitch stitch = getItem(position);
    ItemStitchesBinding binding = (convertView != null)
        ? ItemStitchesBinding.bind(convertView)
        : ItemStitchesBinding.inflate(inflater, parent, false);
    binding.getRoot().setImageDrawable(drawables[stitch.getOrdinalPosition()]);
    return binding.getRoot();
  }

}
