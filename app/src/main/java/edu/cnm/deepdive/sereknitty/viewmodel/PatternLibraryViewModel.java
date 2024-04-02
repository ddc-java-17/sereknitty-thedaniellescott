package edu.cnm.deepdive.sereknitty.viewmodel;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import edu.cnm.deepdive.sereknitty.model.entity.Pattern;
import edu.cnm.deepdive.sereknitty.model.entity.Row;
import edu.cnm.deepdive.sereknitty.model.pojo.PatternWithRows;
import edu.cnm.deepdive.sereknitty.service.PatternRepository;
import edu.cnm.deepdive.sereknitty.service.UserRepository;
import java.util.List;
import javax.inject.Inject;

/**
 * Provides access (For a UI controller or data-bound view) to the current state of the Pattern
 * Library
 */
@HiltViewModel
public class PatternLibraryViewModel extends ViewModel implements DefaultLifecycleObserver {

  private final PatternRepository patternRepository;
  private final UserRepository userRepository;
  private final LiveData<PatternWithRows> pattern;
  private final MutableLiveData<Long> id;
  private final LiveData<List<Row>> rows;

  @Inject
  public PatternLibraryViewModel(PatternRepository patternRepository,
      UserRepository userRepository) {
    this.patternRepository = patternRepository;
    this.userRepository = userRepository;
    id = new MutableLiveData<>();
    pattern = Transformations.switchMap(id, patternRepository::getPattern);
    rows = Transformations.switchMap(id, patternRepository::getRows);

  }

  /**
   * Returns a reference to {@link LiveData} containing the {@link List} of {@link Pattern} for
   * observation by a UI controller.
   */
  public LiveData<List<Pattern>> getPatterns() {
    return patternRepository.getAllPatterns();
  }

  /**
   * Gets a {@link PatternWithRows} instance to hand off to a UI controller.
   *
   * @return pattern {@link PatternWithRows} instance linking a {@code pattern} with the
   * {@code rows} that make it up.
   */
  public LiveData<PatternWithRows> getPattern() {
    return pattern;
  }

  /**
   * Gets a {@link Pattern} by its id.
   *
   * @param id {@link Pattern} id.
   */
  public void fetchPattern(long id) {
    this.id.postValue(id);
  }
}
