package edu.cnm.deepdive.sereknitty.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import dagger.hilt.android.AndroidEntryPoint;
import edu.cnm.deepdive.sereknitty.adapter.PatternLibraryAdapter;
import edu.cnm.deepdive.sereknitty.databinding.FragmentPatternLibraryBinding;
import edu.cnm.deepdive.sereknitty.model.entity.Pattern;
import edu.cnm.deepdive.sereknitty.viewmodel.PatternLibraryViewModel;

/**
 * This is the {@link PatternLibraryFragment} and it holds the logic that recalls {@link Pattern}
 * instances that are represented by individual items in the {@link RecyclerView} in the UI.
 */
@AndroidEntryPoint
public class PatternLibraryFragment extends Fragment {

  private static final String TAG = PatternLibraryFragment.class.getSimpleName();
  private FragmentPatternLibraryBinding binding;
  private PatternLibraryViewModel viewModel;

  /**
   * This is the required empty constructor that Hilt needs to do its thing.
   */
  public PatternLibraryFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    binding = FragmentPatternLibraryBinding.inflate(inflater, container, false);
    return binding.getRoot();

  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ViewModelProvider provider = new ViewModelProvider(requireActivity());
    viewModel = provider.get(PatternLibraryViewModel.class);
    getLifecycle().addObserver(viewModel);
    LifecycleOwner owner = getViewLifecycleOwner();
    viewModel
        .getPatterns()
        .observe(owner, (patterns) -> {
          PatternLibraryAdapter adapter = new PatternLibraryAdapter(requireContext(), patterns,
              (pattern, position, clickedView) -> {
                Navigation.findNavController(binding.getRoot())
                    .navigate(PatternLibraryFragmentDirections
                        .navigateToPatternReader(pattern.getId()));
              });
          binding.patternLibraryList.setAdapter(adapter);
        });
    binding.addPattern.setOnClickListener((button) ->
        Navigation.findNavController(button)
            .navigate(PatternLibraryFragmentDirections.navigateToPatternBuilder()));


  }
}