/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.pinot.spi.config.table.assignment;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import javax.annotation.Nullable;
import org.apache.pinot.spi.config.BaseJsonConfig;


public class SegmentAssignmentConfig extends BaseJsonConfig {

  @JsonPropertyDescription("Configuration for Segment Assignment Strategy")
  @JsonProperty("segmentAssignmentStrategy")
  private final String _assignmentStrategy;

  @JsonPropertyDescription("Name of the column used for partition level segment assignment, when set segments are assigned to instances based on the partition derived from this column")
  @JsonProperty("partitionColumn")
  private final String _partitionColumn;

  @JsonCreator
  public SegmentAssignmentConfig(@JsonProperty(value = "segmentAssignmentStrategy") String assignmentStrategy) {
    this(assignmentStrategy,null);
  }

  @JsonCreator
  public SegmentAssignmentConfig(@JsonProperty(value = "segmentAssignmentStrategy") String assignmentStrategy,
      @Nullable @JsonProperty(value = "partitionColumn") String partitionColumn) {
    _assignmentStrategy = assignmentStrategy;
    _partitionColumn = partitionColumn;
  }

  public String getAssignmentStrategy() {
    return _assignmentStrategy;
  }

  @Nullable
  public String getPartitionColumn() {
    return _partitionColumn;
  }
}
