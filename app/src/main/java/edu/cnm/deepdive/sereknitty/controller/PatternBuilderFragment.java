package edu.cnm.deepdive.sereknitty.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import dagger.hilt.android.AndroidEntryPoint;
import edu.cnm.deepdive.sereknitty.R;

/**
 * This {@link Fragment} is the {@link PatternBuilderFragment}. This {@link Fragment} will hold the
 * logic for the UI where the user will build a {@code pattern}
 */
@AndroidEntryPoint
public class PatternBuilderFragment extends Fragment {

  /**
   * This is the required empty constructor for Hilt to use.
   */
  public PatternBuilderFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_pattern_builder, container, false);
  }
}