package org.apache.spark.sql.gt.types

import geotrellis.raster.histogram.Histogram
import org.apache.spark.sql.types._

/**
 * Wraps up GT Histogram type.
 *
 * @author sfitch 
 * @since 4/18/17
 */
private[gt] class HistogramUDT extends UserDefinedType[Histogram[Double]]
  with KryoBackedUDT[Histogram[Double]] {

  override val typeName = "st_histogram"

  override val targetClassTag = scala.reflect.classTag[Histogram[Double]]
}

object HistogramUDT extends HistogramUDT
