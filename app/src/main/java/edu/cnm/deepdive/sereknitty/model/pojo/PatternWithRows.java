package edu.cnm.deepdive.sereknitty.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.sereknitty.model.entity.Pattern;
import edu.cnm.deepdive.sereknitty.model.entity.Row;
import java.util.List;

/**
 * This POJO is a class that allows for a multi-table join allowing me to recall the {@code rows}
 * associated with a particular {@link Pattern} instance. It is not an entity, but it allows for
 * more complicated queries without complicated SQL code.
 */
public class PatternWithRows extends Pattern {

  @Relation(entity = Row.class, entityColumn = "pattern_id", parentColumn = "pattern_id")
  private List<RowWithStitches> rows;

  /**
   * This getter gets the {@link List} of {@code rows} associated with a particular
   * {@link Pattern}.
   */
  public List<RowWithStitches> getRows() {
    return rows;
  }

  /**
   * This setter sets the {@link List} of {@code rows} associated with a particular
   * {@link Pattern}.
   */
  public void setRows(List<RowWithStitches> rows) {
    this.rows = rows;
  }
}
