/*
 * Copyright 2017 Astraea, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.sql.gt.types

import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.types.{UDTRegistration, UserDefinedType}

/**
 *
 * @author sfitch 
 * @since 4/12/17
 */
private[gt] object Registrar {
  def register(sqlContext: SQLContext): Unit = {
    register(TileUDT)
    register(MultibandTileUDT)
    register(ExtentUDT)
    register(ProjectedExtentUDT)
    register(TemporalProjectedExtentUDT)
    register(HistogramUDT)
  }

  private def register(udt: UserDefinedType[_]): Unit = {
    UDTRegistration.register(
      udt.userClass.getCanonicalName,
      udt.getClass.getSuperclass.getName
    )
  }
}
