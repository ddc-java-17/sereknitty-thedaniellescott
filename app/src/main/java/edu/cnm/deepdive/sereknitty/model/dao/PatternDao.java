package edu.cnm.deepdive.sereknitty.model.dao;

import android.app.VoiceInteractor.CompleteVoiceRequest;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.sereknitty.model.entity.Pattern;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface PatternDao {

  // Do I really need to implement SQL queries here? If so...
  // TODO: 2/26/2024 Implement SQL queries for pattern searches
  String TRUNCATION_QUERY = "DELETE FROM pattern";

  @Insert
  Single<Long> insert(Pattern pattern);

  // Frog the pattern... PERMANENTLY! ;P
  @Query(TRUNCATION_QUERY)
  Completable truncatePattern();


}
