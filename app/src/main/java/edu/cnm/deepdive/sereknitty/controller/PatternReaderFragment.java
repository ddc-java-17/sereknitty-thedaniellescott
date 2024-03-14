package edu.cnm.deepdive.sereknitty.controller;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import edu.cnm.deepdive.sereknitty.R;
import edu.cnm.deepdive.sereknitty.databinding.FragmentPatternReaderBinding;

/**
 * This fragment holds the PatternReader that the user will use to read their current pattern.
 */
public class PatternReaderFragment extends Fragment {

  private FragmentPatternReaderBinding binding;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    binding = FragmentPatternReaderBinding.inflate(inflater, container, false);
    return inflater.inflate(R.layout.fragment_pattern_reader, container, false);
  }
}