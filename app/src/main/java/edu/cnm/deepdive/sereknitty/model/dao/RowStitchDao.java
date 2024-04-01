package edu.cnm.deepdive.sereknitty.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.sereknitty.model.entity.Row;
import edu.cnm.deepdive.sereknitty.model.entity.RowStitch;
import io.reactivex.rxjava3.core.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface RowStitchDao {

  @Insert
  Single<Long> insert(RowStitch rowStitch);

  @Insert
  Single<List<Long>> insert(Collection<RowStitch> stitches);

  @Update
  Single<Integer> update(RowStitch stitch);

  @Query("SELECT * FROM row_stitch WHERE ordinal_position = :position")
  LiveData<RowStitch> select(int position);

  @Query("SELECT * FROM row_stitch WHERE row_id = :rowId ORDER BY ordinal_position")
  LiveData<List<RowStitch>> selectForRow(long rowId);
}
