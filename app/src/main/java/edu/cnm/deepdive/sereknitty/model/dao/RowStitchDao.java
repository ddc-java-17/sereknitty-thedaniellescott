package edu.cnm.deepdive.sereknitty.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.sereknitty.model.entity.RowStitch;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface RowStitchDao {

  @Insert
  Single<Long> insert(RowStitch rowStitch);

  @Query("SELECT * FROM row_stitch WHERE ordinal_position = :position")
  LiveData<RowStitch> select(int position);

}
