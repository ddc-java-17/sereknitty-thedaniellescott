package edu.cnm.deepdive.sereknitty.model.dao;

import android.app.VoiceInteractor.CompleteVoiceRequest;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.sereknitty.model.entity.Pattern;
import edu.cnm.deepdive.sereknitty.model.entity.User;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface PatternDao {

  // TODO: 2/26/2024 Implement SQL queries for pattern searches
  String TRUNCATION_QUERY = "DELETE FROM pattern";

  @Insert
  Single<Long> insert(Pattern pattern);

  @Query("SELECT * FROM user WHERE pattern_id = :id")
  LiveData<Pattern> select(long id);

  // Frog the pattern... PERMANENTLY! ;P
  @Query(TRUNCATION_QUERY)
  Completable truncatePattern();


}
