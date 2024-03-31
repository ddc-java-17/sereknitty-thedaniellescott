package edu.cnm.deepdive.sereknitty.controller;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.AndroidEntryPoint;
import edu.cnm.deepdive.sereknitty.R;
import edu.cnm.deepdive.sereknitty.databinding.FragmentPatternReaderBinding;
import edu.cnm.deepdive.sereknitty.viewmodel.PatternLibraryViewModel;

/**
 * This fragment holds the PatternReader that the user will use to read their current pattern.
 */
@AndroidEntryPoint
public class PatternReaderFragment extends Fragment {

  private FragmentPatternReaderBinding binding;
  private PatternLibraryViewModel viewModel;
  private long patternId;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    binding = FragmentPatternReaderBinding.inflate(inflater, container, false);
    patternId = PatternReaderFragmentArgs.fromBundle(getArguments()).getPatternId();
    binding = FragmentPatternReaderBinding.inflate(inflater, container, false);
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(requireActivity()).get(PatternLibraryViewModel.class);
    viewModel.getPattern().observe(getViewLifecycleOwner(), (pattern) -> {
      Log.d(getClass().getSimpleName(), "fetched pattern " + pattern.getPatternName());
      // TODO: 3/30/2024 Create an instance of the Adapter and attach that instance to the ListView.

    });
    viewModel.fetchPattern(patternId);
  }
}