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
  Single<String> insert(RowStitch rowStitch);

  @Query("SELECT * FROM row_stitch WHERE stitch_name = :name")
  LiveData<RowStitch> select(String name);

}
