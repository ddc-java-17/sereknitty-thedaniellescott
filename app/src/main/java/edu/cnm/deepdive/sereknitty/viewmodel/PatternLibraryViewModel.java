package edu.cnm.deepdive.sereknitty.viewmodel;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import edu.cnm.deepdive.sereknitty.model.pojo.PatternWithRows;
import edu.cnm.deepdive.sereknitty.model.entity.Pattern;
import edu.cnm.deepdive.sereknitty.model.entity.Row;
import edu.cnm.deepdive.sereknitty.service.PatternRepository;
import edu.cnm.deepdive.sereknitty.service.UserRepository;
import java.util.List;
import javax.inject.Inject;

@HiltViewModel
public class PatternLibraryViewModel extends ViewModel implements DefaultLifecycleObserver {

  private final PatternRepository patternRepository;
  private final UserRepository userRepository;
  private final LiveData<PatternWithRows> pattern;
  private final MutableLiveData<Long> id;
  private final LiveData<List<Row>> rows;

  @Inject
  public PatternLibraryViewModel(PatternRepository patternRepository, UserRepository userRepository) {
    this.patternRepository = patternRepository;
    this.userRepository = userRepository;
    id = new MutableLiveData<>();
    pattern = Transformations.switchMap(id, patternRepository::getPattern);
    rows = Transformations.switchMap(id, patternRepository::getRows);

  }



  public LiveData<List<Pattern>> getPatterns() {
    return patternRepository.getAllPatterns();
  }

  public LiveData<PatternWithRows> getPattern() {
    return pattern;
  }

  public void fetchPattern(long id) {
    this.id.postValue(id);
  }
}
